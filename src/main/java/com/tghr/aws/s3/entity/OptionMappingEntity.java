package com.tghr.aws.s3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tc_mapping_car_option")
public class OptionMappingEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ca_opt_map_id")
	private Long caOptMapId;

	@Column(name = "tc_id")
	private String tcId;

	@Column(name = "opt_cd")
	private String optCd;

	@Column(name = "del_yn")
	private String delYn;

	@Builder
	public OptionMappingEntity(Long caOptMapId, String tcId, String optCd, String delYn) {
		super();
		this.caOptMapId = caOptMapId;
		this.tcId = tcId;
		this.optCd = optCd;
		this.delYn = delYn;
	}
}
