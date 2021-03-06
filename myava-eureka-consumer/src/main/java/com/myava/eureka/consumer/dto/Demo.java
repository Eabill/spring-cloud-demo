package com.myava.eureka.consumer.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@ApiModel
public class Demo {
	
	@ApiModelProperty(value = "名称", required = true)
	private String name;
	
	@ApiModelProperty(value = "备注", required = true)
	private String remark;

}
