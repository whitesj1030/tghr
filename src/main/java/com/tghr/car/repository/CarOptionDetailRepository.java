package com.tghr.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tghr.car.model.CarOptionDetail;


public interface CarOptionDetailRepository extends JpaRepository<CarOptionDetail, Long> {
	
	@Query(value="select * from tc_car_option_detail u where u.car_id = :carId", nativeQuery=true)	
	List<CarOptionDetail> findCarsByCarIdUsingNamedParameters(@Param("carId") Long carId);
}
