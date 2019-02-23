package com.myava.eureka.dto;

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
@ApiModel(value = "响应结果")
public class RespResult<T> {
	
	private static final String MSG_SUCCESS = "操作成功";
	private static final int CODE_SUCCESS = 200;
	
	/**
	 * 返回结果的code
	 */
	@ApiModelProperty(value = "状态码", required = true)
	private int code;

    /**
	 * 返回结果的提示信息
	 */
    @ApiModelProperty(value = "提示信息", required = true)
    private String message;
	
    /**
	 * 返回结果的数据
	 */
	@ApiModelProperty("返回数据")
    T data;
	
	public static <T> RespResult<T> success(T data) {
		return new RespResult<T>(CODE_SUCCESS, MSG_SUCCESS, data);
	}
	
}
