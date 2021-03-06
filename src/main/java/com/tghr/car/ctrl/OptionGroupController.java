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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tghr.car.model.OptionGroup;
import com.tghr.car.service.OptionGroupService;
import com.tghr.comm.consts.AppConstants;
import com.tghr.comm.util.PageRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;

@Api(value = "[마스터] 옵션 Group API", tags = {"[마스터] 옵션Group 마스터데이터 API"})
@RestController
@AllArgsConstructor
@RequestMapping(value= "/api/optgrp")
public class OptionGroupController {
	
	private static final Logger logger = LoggerFactory.getLogger(OptionGroupController.class);
	
	@Autowired
    private OptionGroupService optionGroupService;

	@ApiOperation(value = "옵션 그룹리스트 검색", notes = "옵션 그룹 정보 조회 (페이징 처리 및 정렬 인자 기준으로 정렬)")
	@GetMapping("")
    public Page<OptionGroup> getOptionGroupList(@ApiParam(value = "페이지 번호", required = false, example = "1") @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
    		@ApiParam(value = "페이지 사이즈", required = false, example = "10") @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
    		@ApiParam(value = "정렬 기준 속성", required = false, example = "optGrpId") @RequestParam(value = "searchparam", defaultValue = AppConstants.DEFAULT_SEARCH_PARAM) String searchparam,
    		@ApiParam(value = "정렬방법", required = false, example = "DESC or ASC") @RequestParam(value = "direction", defaultValue = AppConstants.DEFAULT_DIRECTION) String direction) {
		logger.debug("getOptionGroupList called");
		return optionGroupService.findAll(new PageRequest(page, size, searchparam, direction).of());    	
    }	
	
	@ApiOperation(value = "옵션그룹 등록", notes = "옵션그룹 정보 등록 ")
	@PostMapping("")
	public ResponseEntity<Object> createOptionGroup(@RequestBody OptionGroup optionGroup) {
		logger.debug("savedOptionGroup called. optionGroup ID :"+ optionGroup.getOptGrpId());
		OptionGroup savedOptionGroup = optionGroupService.saveOptionGroup(optionGroup);		
		return ResponseEntity.status(HttpStatus.OK).body(savedOptionGroup);
	}	

	@ApiOperation(value = "옵션그룹 갱신", notes = "옵션그룹 정보 갱신 ")
	@PutMapping("")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<Object> updateOptionGroup(@RequestBody OptionGroup optionGroup) {
		logger.debug("updateOptionGroup called. optionGroup ID :"+ optionGroup.getOptGrpId());
		OptionGroup updatedOptionGroup = optionGroupService.updateOptionGroup(optionGroup);		
		return ResponseEntity.status(HttpStatus.OK).body(updatedOptionGroup);
	}
		
	@ApiOperation(value = "옵션 그룹 삭제", notes = "옵션 그룹 아이디로 삭제")
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public void deleteById(@PathVariable long id) {
		logger.debug("deleteById called. optionGroup ID :"+ id);
		optionGroupService.deleteById(id);
	}

}
