package com.example.ecommerce.support.api;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiResponseGenerator {

	private ApiResponseGenerator() {
		throw new UnsupportedOperationException();
	}

	public static ApiResponse<Void> success() {
		return ApiResponse.<Void>builder().success(true).build();
	}

	public static <D> ApiResponse<D> success(final D data) {
		return ApiResponse.<D>builder().success(true).data(data).build();
	}

	public static ApiResponse<Void> fail(final HttpStatus status) {
		return ApiResponseGenerator.fail(status.getReasonPhrase());
	}

	public static ApiResponse<Void> fail(final String message) {
		return ApiResponse.<Void>builder().message(message).build();
	}

	public static ApiResponse<Void> fail(final String code, final String message) {
		return ApiResponse.<Void>builder().code(code).message(message).build();
	}

	public static ApiResponse<Void> fail(final HttpStatus status, final List<BindingError> errors) {
		return ApiResponseGenerator.fail(status.getReasonPhrase(), errors);
	}

	public static ApiResponse<Void> fail(final String message, final List<BindingError> errors) {
		return ApiResponse.<Void>builder().message(message).errors(errors).build();
	}
}
