package com.rating.service.services;

import java.util.List;

import com.rating.service.eitity.Rating;

public interface RatingService {
	
	Rating createRating(Rating rating);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getAllByHotelId(String hotelId);

}
