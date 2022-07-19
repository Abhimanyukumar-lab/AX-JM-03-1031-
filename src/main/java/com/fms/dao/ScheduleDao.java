package com.fms.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.fms.model.Schedule;


public interface ScheduleDao extends CrudRepository<Schedule, BigInteger>{

}
