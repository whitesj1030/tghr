package com.tghr.car.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tghr.car.dto.CarDto;
import com.tghr.car.dto.CarDto.CarQueryReq;
import com.tghr.car.model.Car;
import com.tghr.car.service.CarService;
import com.tghr.comm.consts.AppConstants;
import com.tghr.comm.util.PageRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "[1] 차량정보 API", tags = { "[1] 차량정보 API " })
@RestController
@RequestMapping(value = "/api/car")
public class CarController {

	private static final Logger logger = LoggerFactory.getLogger(CarController.class);

	@Autowired
	private CarService carService;

	@ApiOperation(value = "차량리스트 검색", notes = "차량 정보 조회 (페이징 처리 및 정렬 인자 기준으로 정렬)")
	@GetMapping("/list")
	public Page<CarDto> getCarList(
			@ApiParam(value = "페이지 번호", required = false, example = "1") @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
			@ApiParam(value = "페이지 사이즈", required = false, example = "10") @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
			@ApiParam(value = "정렬 기준 속성", required = false, example = "carId") @RequestParam(value = "searchparam", defaultValue = AppConstants.DEFAULT_SEARCH_PARAM) String searchparam,
			@ApiParam(value = "정렬방법", required = false, example = "DESC or ASC") @RequestParam(value = "direction", defaultValue = AppConstants.DEFAULT_DIRECTION) String direction,
			@ApiParam(value = "검색조건", required = false, example = "carkind: 경차(L), 준중형(S), 중형(M), 대형(B), SUV(S), 기타(E) , fuel: 가솔린(G), LPG(L), 디젤(D), name") @ModelAttribute CarQueryReq carQueryReq) {
		logger.debug("getCarList called.  ");
		return carService.findAll(carQueryReq, new PageRequest(page, size, searchparam, direction).of());
	}

//    public ResponseEntity<Page<Car>> getCarList(@ApiParam(value = "페이지 번호", required = false, example = "1") @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
//    		@ApiParam(value = "페이지 사이즈", required = false, example = "10") @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
//    		@ApiParam(value = "정렬 기준 속성", required = false, example = "carId") @RequestParam(value = "searchparam", defaultValue = AppConstants.DEFAULT_SEARCH_PARAM) String searchparam,
//    		@ApiParam(value = "정렬방법", required = false, example = "DESC or ASC") @RequestParam(value = "direction", defaultValue = AppConstants.DEFAULT_DIRECTION) String direction,
//    		@ApiParam(value = "검색조건", required = false, example = "kind, fuel, name") @RequestParam(required = false) Map<String, Object> searchRequest) {
//		logger.debug("getCarList called.  ");
//		return ResponseEntity.ok(carService.findAll(searchRequest, new PageRequest(page, size, searchparam, direction).of()));    	
//    }

	@ApiOperation(value = "차량 검색", notes = "차 아이디로 검색")
	@GetMapping("{id}")
	public ResponseEntity<Object> getCarInfo(@PathVariable long id) {
		logger.debug("getCarInfo called. ID is " + id);
		Car car = carService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(car);
	}

	@ApiOperation(value = "차량 검색", notes = "차 아이디로 검색")
	@GetMapping("/one/{id}")
	public ResponseEntity<Object> findCarsByIdUsingQuery(@PathVariable long id) {
		logger.debug("findCarsByIdUsingQuery called. ID is " + id);
		Car car = carService.findCarsByIdUsingQuery(id);
		return ResponseEntity.status(HttpStatus.OK).body(car);
	}

	@ApiOperation(value = "차량 등록", notes = "차량 정보 등록 -(파일, 옵션은 별도 등록")
	@PostMapping("")
	public ResponseEntity<Object> createCar(@RequestBody Car car) {
		logger.debug("createCar called. ID is " + car.getCarId());
		Car savedCar = carService.saveCar(car);
		return ResponseEntity.status(HttpStatus.OK).body(savedCar);
	}

	@ApiOperation(value = "차량 갱신", notes = "차량 정보 갱신")
	@PutMapping("")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<Object> updateCar(@RequestBody Car car) {
		logger.debug("updateCar called. ID is " + car.getCarId());
		Car updateCar = carService.updateCar(car);
		return ResponseEntity.status(HttpStatus.OK).body(updateCar);
	}

	@ApiOperation(value = "차량 삭제", notes = "차 아이디로 삭제")
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public void deleteById(@PathVariable long id) {
		logger.debug("deleteById called. ID is " + id);
		carService.deleteById(id);
	}

}
