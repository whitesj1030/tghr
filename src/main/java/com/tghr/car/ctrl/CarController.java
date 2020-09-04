package com.tghr.car.ctrl;

import java.net.URI;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tghr.car.model.Car;
import com.tghr.car.service.CarService;
import com.tghr.comm.consts.AppConstants;
import com.tghr.comm.util.PageRequest;
import com.tghr.common.exception.CarNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

@Api(value = "차량정보 API", tags = {"차량정보 API (CRUD)"})
@RestController
@AllArgsConstructor
@RequestMapping(value= "/api/car")
public class CarController {
	
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
    private CarService carService;

	@ApiOperation(value = "차량리스트 검색", notes = "차량 정보 조회 (페이징 처리 및 정렬 인자 기준으로 정렬)")
	@GetMapping("/list")
    public Page<Car> getCarList(@ApiParam(value = "페이지 번호", required = false, example = "1") @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
    		@ApiParam(value = "페이지 사이즈", required = false, example = "10") @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
    		@ApiParam(value = "정렬 기준 속성", required = false, example = "carId") @RequestParam(value = "searchparam", defaultValue = AppConstants.DEFAULT_SEARCH_PARAM) String searchparam,
    		@ApiParam(value = "정렬방법", required = false, example = "DESC or ASC") @RequestParam(value = "direction", defaultValue = AppConstants.DEFAULT_DIRECTION) String direction) {
	
		return carService.findAll(new PageRequest(page, size, searchparam, direction).of());    	
    }
	
	@ApiOperation(value = "차량 검색", notes = "차 아이디로 검색")
	@GetMapping("{id}")
	public Car getCarInfo(@PathVariable long id) {
		Optional<Car> car = carService.findById(id);
		car.orElseThrow(() -> new CarNotFoundException("id-" + id));	
		return car.get();
	}
	
	@ApiOperation(value = "차량 검색", notes = "차 아이디로 검색")
	@GetMapping("/one/{id}")
	public Car findCarsByIdUsingQuery(@PathVariable long id) {
		Car car = carService.findCarsByIdUsingQuery(id);
		if (null == car)
			throw new CarNotFoundException("id-" + id);
		return car;
	}	
	
	@ApiOperation(value = "차량 등록", notes = "차량 정보 등록 -(파일, 옵션은 별도 등록")
	@PostMapping("")
	public ResponseEntity<Object> createCar(@RequestBody Car car) {
		Car savedCar = carService.saveCar(car);
		return ResponseEntity.created(this.getLocation(savedCar)).build();
	}
	
	@ApiOperation(value = "차량 갱신", notes = "차량 정보 갱신")
	@PutMapping("")
	public ResponseEntity<Object> updateCar(@RequestBody Car car) {
		Car updateCar = carService.updateCar(car);
		return ResponseEntity.created(this.getLocation(updateCar)).build();
	}
	
	@ApiOperation(value = "차량 삭제", notes = "차 아이디로 삭제")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		carService.deleteById(id);
	}
	
	private URI getLocation(Car car) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("")
				.buildAndExpand(car.getCarId()).toUri();
	}
	
}
