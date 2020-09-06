package com.tghr.car.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tghr.car.model.OptionGroup;
import com.tghr.car.repository.OptionGroupRepository;
import com.tghr.comm.exception.OptionGroupNotFoundException;

import lombok.RequiredArgsConstructor;

/**
 * 차량 옵션 그룹 마스터 데이터 관리
 * @author white
 *
 */
@Service
@Transactional
@RequiredArgsConstructor
public class OptionGroupService {

	@Autowired
    private OptionGroupRepository optionGroupRepository;	
	
    @Transactional(readOnly = true)
    public Page<OptionGroup> findAll(Pageable pageable) {
        return optionGroupRepository.findAll(pageable);
    }
		
	public Optional<OptionGroup> findById(Long id)	{
		return optionGroupRepository.findById(id);
	}
	
	public OptionGroup saveOptionGroup(OptionGroup optionGroup) {		
		return optionGroupRepository.save(optionGroup);
	}
	
	public OptionGroup updateOptionGroup(OptionGroup optionGroup) {
	Optional<OptionGroup> carOpOptional = optionGroupRepository.findById(optionGroup.getOptGrpId());
	carOpOptional.orElseThrow(() -> new OptionGroupNotFoundException("id:"+optionGroup.getOptGrpId()));
	return optionGroupRepository.save(optionGroup);
	}
	
	public void deleteById(Long id) {
		optionGroupRepository.deleteById(id);
	}
}
