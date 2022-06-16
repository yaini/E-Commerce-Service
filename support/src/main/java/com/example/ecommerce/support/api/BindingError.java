package com.example.ecommerce.support.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BindingError {

	private String field;

	private String reason;
}
