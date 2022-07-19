package com.fms.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.fms.model.Flight;



public interface FlightDao extends CrudRepository<Flight,BigInteger> {

}
