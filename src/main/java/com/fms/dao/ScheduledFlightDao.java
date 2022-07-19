package com.fms.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.fms.model.ScheduledFlight;


public interface ScheduledFlightDao extends CrudRepository<ScheduledFlight, BigInteger>{

}
