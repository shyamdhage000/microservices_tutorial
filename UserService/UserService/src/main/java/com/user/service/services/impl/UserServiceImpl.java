package com.user.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entities.Ratings;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repo.UserRepository;
import com.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private org.slf4j.Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		//generate unique user id ecery time
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		User user= userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id not found on server"));
		//fetch ratings of the above user from rating service
		ArrayList<Ratings> ratingsOfUsers=restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);		
		logger.info("{}", ratingsOfUsers);
		user.setRatings(ratingsOfUsers);
		return user;
	}
	
	@Override
	public String deleteUser(String userId) {
		userRepository.deleteById(userId);
		return "User Deleted Successfully";
	}

	@Override
	public User updateUser(User user, String userId) {
		Optional<User> user1=userRepository.findById(userId);
		User user2 = user1.get();
		 if(user1!=null) {
			user2.setAbout(user.getAbout());
			user2.setEmail(user.getEmail());
			user2.setName(user.getName());
		 }
	 return	userRepository.save(user2);
}
	
}
