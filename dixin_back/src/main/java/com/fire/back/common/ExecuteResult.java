package com.fire.back.common;

import lombok.Data;

@Data
public class ExecuteResult<T> {

	private String code;

	private String msg;

	private Integer count;

	private T data;

}
