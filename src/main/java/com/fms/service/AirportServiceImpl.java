package com.fms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fms.dao.AirportDao;
import com.fms.exceptions.RecordAlreadyPresentException;
import com.fms.exceptions.RecordNotFoundException;
import com.fms.model.Airport;


@Service
public class AirportServiceImpl implements AirportService{
	
	
	
	@Autowired
	AirportDao airportDao;

	/*
	 * view all Airports
	 */
	@Override
	public Iterable<Airport> viewAllAirport() {
		return airportDao.findAll();
	}

	/*
	 * view airport by airportCode
	 */
	@Override
	public Airport viewAirport(String airportCode) {
		Optional<Airport> findById = airportDao.findById(airportCode);
		if (findById.isPresent()) {
			return findById.get();
		}
			
			//return new ResponseEntity<Airport>(airport, HttpStatus.OK)}
		else
			throw new RecordNotFoundException("Airport with airport code: " + airportCode + "not exists");
	    }
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
        }*/

	/*
	 * add a airport
	 */
	@Override
	public ResponseEntity<?> addAirport(Airport airport) {
		Optional<Airport> findById = airportDao.findById(airport.getAirportCode());
		try {
		if (!findById.isPresent()) {
			airportDao.save(airport);
			return new ResponseEntity<Airport>(airport,HttpStatus.OK);
		} 
		else
			throw new RecordAlreadyPresentException(
					"Airport with code : " + airport.getAirportCode() + " already present");
	     }
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<Airport>(airport,HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * modify an Airport
	 */
	@Override
	public Airport modifyAirport(Airport airport) {
		Optional<Airport> findById = airportDao.findById(airport.getAirportCode());
		if (findById.isPresent()) {
			airportDao.save(airport);
		} 
		else
			throw new RecordNotFoundException("Airport with code: " + airport.getAirportCode() + " not exists");
		return airport;
	}

	/*
	 * remove an airport
	 */
	@Override
	public String removeAirport(String airportCode) {
		Optional<Airport> findById = airportDao.findById(airportCode);
		if (findById.isPresent()) {
			airportDao.deleteById(airportCode);
			return "Airport removed";
		} else
			throw new RecordNotFoundException("Airport with code: " + airportCode + " not exists");

	}
	
	
	

}
