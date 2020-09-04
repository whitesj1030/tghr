package com.tghr.car.reposigory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tghr.car.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	
	@Query(value="select * from tc_car u where u.car_id = :carId", nativeQuery=true)	
	Car findCarsByCarIdUsingNamedParameters(@Param("carId") Long carId);
    //Car findCarsByIdUsingQuery(Long carId);

	//@Query("select u from User u where u.name = :name")
	
}
