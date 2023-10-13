package com.rating.service.eitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="rating")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

	@Id
	@Column(name="Id")
	private String ratingId;
	
	@Column(name="UserId")
	private String userId;
	
	@Column(name="HotelId")
	private String hotelId;
	
	@Column(name="Rating")
	private int rating;
	
	@Column(name="feedback")
	private String feedback;

}
