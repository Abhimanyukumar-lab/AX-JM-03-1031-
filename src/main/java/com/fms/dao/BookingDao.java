package com.fms.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.fms.model.Booking;



public interface BookingDao extends CrudRepository<Booking, BigInteger> {

}
