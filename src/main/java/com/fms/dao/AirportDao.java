package com.fms.dao;

import org.springframework.data.repository.CrudRepository;

import com.fms.model.Airport;

public interface AirportDao extends CrudRepository<Airport, String>{

}
