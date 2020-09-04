package com.tghr.car.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tghr.comm.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tc_car_option_group")
public class OptionGroup extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "opt_grp_id")
	private Long optGrpId;
	
	@Column(name = "opt_grp_nm")
	private String optGrpNm;

	public OptionGroup(Long optGrpId, String optGrpNm) {
		super();
		this.optGrpId = optGrpId;
		this.optGrpNm = optGrpNm;
	}
	
}
