package com.tghr.car.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tghr.comm.entity.BaseEntity;

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
	@Column(name = "opt_id")
	private Long optId;

	@Column(name = "opt_grp_id")
	private Long optGrpId;
	
	@Column(name = "opt_nm")
	private String optNm;
	
	@Column(name = "opt_desc")
	private String optDesc;
	
    @OneToOne
    @JoinColumn(name = "opt_grp_id", insertable = false, updatable = false) 
    private OptionGroup optionGroup;
    
    @Transient
	private String optGrpNm;

	@Builder
	public CarOption(Long optId, Long optGrpId, String optNm, String optDesc, OptionGroup optionGroup) {
		super();
		this.optId = optId;
		this.optGrpId = optGrpId;
		this.optNm = optNm;
		this.optDesc = optDesc;
		this.optionGroup = optionGroup;
	}
	
	public void setOptGrpNm() {
		this.optGrpNm = optionGroup.getOptGrpNm();
	}
	
}
