package com.example.ecommerce.support.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ApiResponse<T> {

	private final boolean success;

	@JsonInclude(Include.NON_EMPTY)
	private final String code;

	@JsonInclude(Include.NON_EMPTY)
	private final String message;

	@JsonInclude(Include.NON_EMPTY)
	private final List<BindingError> errors;

	private final T data;

	@Builder
	public ApiResponse(
			boolean success,
			final String code,
			final String message,
			final List<BindingError> errors,
			final T data) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.errors = errors;
		this.data = data;
	}
}
