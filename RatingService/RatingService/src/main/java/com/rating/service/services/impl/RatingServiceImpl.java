package com.rating.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.eitity.Rating;
import com.rating.service.repo.RatingRepository;
import com.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	
	@Override
	public Rating createRating(Rating rating) {
		String randoRatingId=UUID.randomUUID().toString();
		rating.setRatingId(randoRatingId);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllByHotelId(String hotelId) {
		
		return ratingRepository.findByHotelId(hotelId);
	}

}
