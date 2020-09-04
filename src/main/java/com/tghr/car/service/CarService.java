package com.tghr.car.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tghr.car.model.Car;
import com.tghr.car.reposigory.CarRepository;
import com.tghr.common.exception.CarNotFoundException;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CarService {

	@Autowired
    private CarRepository carRepository;	
	
    public Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }
	
	public Car findCarsByIdUsingQuery(Long id)	{
		return carRepository.findCarsByCarIdUsingNamedParameters(id);
	}
        
	public Optional<Car> findById(Long id)	{
		return carRepository.findById(id);
	}
	
	public Car saveCar(Car car) {		
		return carRepository.save(car);
	}
	
	public Car updateCar(Car car) {
	Optional<Car> carOptional = carRepository.findById(car.getCarId());
	carOptional.orElseThrow(() -> new CarNotFoundException("id:"+car.getCarId()));
	return carRepository.save(car);
	}
	
	public void deleteById(Long id) {
		carRepository.deleteById(id);
	}
}
