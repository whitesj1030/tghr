package com.tghr.car.ctrl;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tghr.car.model.CarOptionDetail;
import com.tghr.car.service.CarOptionDetailService;
import com.tghr.comm.consts.AppConstants;
import com.tghr.comm.util.PageRequest;
import com.tghr.common.exception.CarOptionDetailNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

@Api(value = "개별 차량 옵션별 옵션 정보 API", tags = {"개별 차량 옵션별 옵션정보 API (CRUD)"})
@RestController
@AllArgsConstructor
@RequestMapping(value= "/api/optdetail")
public class CarOptionDetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(CarOptionDetailController.class);
	
	@Autowired
    private CarOptionDetailService carOptionDetailService;

	@ApiOperation(value = "개별 차량 옵션리스트 검색", notes = "개별 차량 옵션 정보 조회 (페이징 처리 및 정렬 인자 기준으로 정렬)")
	@GetMapping("/list")
    public Page<CarOptionDetail> getCarOptionDetailList(@ApiParam(value = "페이지 번호", required = false, example = "1") @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
    		@ApiParam(value = "페이지 사이즈", required = false, example = "10") @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
    		@ApiParam(value = "정렬 기준 속성", required = false, example = "carOptionDetailId") @RequestParam(value = "searchparam", defaultValue = AppConstants.DEFAULT_SEARCH_PARAM) String searchparam,
    		@ApiParam(value = "정렬방법", required = false, example = "DESC or ASC") @RequestParam(value = "direction", defaultValue = AppConstants.DEFAULT_DIRECTION) String direction) {
	
		return carOptionDetailService.findAll(new PageRequest(page, size, searchparam, direction).of());    	
    }
	
	@ApiOperation(value = "개별 차량 옵션 검색", notes = "차 아이디로 검색")
	@GetMapping("/{carId}")
	public List<CarOptionDetail> getCarOptionDetailInfo(@PathVariable long carId) {
		return carOptionDetailService.findByCarId(carId);
	}
	
	@ApiOperation(value = "개별 차량 옵션 등록", notes = "개별 차량 옵션 정보 등록")
	@PostMapping("")
	@ResponseBody
	public List<CarOptionDetail> createCarOptionDetail(@RequestBody List<CarOptionDetail> carOptionDetailList) {
		return carOptionDetailService.saveCarOptionDetail(carOptionDetailList);	
	}
	
	@ApiOperation(value = "개별 차량 옵션 갱신", notes = "개별 차량 옵션 정보 갱신")
	@PutMapping("/{id}")
	@ResponseBody
	public List<CarOptionDetail> updateCarOptionDetail(@RequestBody List<CarOptionDetail> carOptionDetailList) {
		return carOptionDetailService.updateCarOptionDetail(carOptionDetailList);	
	}
	
	@ApiOperation(value = "개별 차량 옵션 삭제", notes = "차 아이디로 삭제")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		carOptionDetailService.deleteById(id);
	}
	
}
