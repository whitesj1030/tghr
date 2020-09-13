package com.tghr.car.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tghr.comm.entity.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tc_car_option_group")
public class OptionGroup extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value="옵션 그룹 ID: 자동생성")
	@Column(name = "opt_grp_id")
	private Long optGrpId;
	
	@ApiModelProperty(value="옵션 그룹 명")
	@Column(name = "opt_grp_nm")
	private String optGrpNm;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "opt_grp_id")  
	private List<CarOption> carOptionList = new ArrayList<>();

	@Builder
	public OptionGroup(Long optGrpId, String optGrpNm, List<CarOption> carOptionList) {
		super();
		this.optGrpId = optGrpId;
		this.optGrpNm = optGrpNm;
		this.carOptionList = carOptionList;
	}
	
}
