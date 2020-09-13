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
import javax.persistence.Transient;

import com.tghr.comm.entity.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tc_car_option")
public class CarOption extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value="옵션 ID : 자동생성 ")
	@Column(name = "opt_id")
	private Long optId;

	@ApiModelProperty(value="옵션 그룹 ID")
	@Column(name = "opt_grp_id")
	private Long optGrpId;
	
	@ApiModelProperty(value="옵션명")
	@Column(name = "opt_nm")
	private String optNm;
	
	@ApiModelProperty(value="옵션 설명")
	@Column(name = "opt_desc")
	private String optDesc;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "opt_id")  
	private List<CarOptionDetail> carOptionDetailList = new ArrayList<>();
    
    @Transient
	private String optGrpNm;

	@Builder
	public CarOption(Long optId, Long optGrpId, String optNm, String optDesc,  List<CarOptionDetail> carOptionDetailList) {
		super();
		this.optId = optId;
		this.optGrpId = optGrpId;
		this.optNm = optNm;
		this.optDesc = optDesc;		
		this.carOptionDetailList = carOptionDetailList;
	}	
}
