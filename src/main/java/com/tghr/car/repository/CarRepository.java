package com.tghr.car.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tghr.car.model.Car;


public interface CarRepository extends JpaRepository<Car, Long>,  JpaSpecificationExecutor<Car> {
	
	@Query(value="select * from tc_car u where u.car_id = :carId", nativeQuery=true)	
	Car findCarsByCarIdUsingNamedParameters(@Param("carId") Long carId);
    //Car findCarsByIdUsingQuery(Long carId);

	Page<Car> findAll(Specification<Car> spec, Pageable pageable);
	
}
