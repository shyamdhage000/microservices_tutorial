package com.hotel.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.service.entity.Hotel;

public interface HotelRepository  extends JpaRepository<Hotel,String>{

}
