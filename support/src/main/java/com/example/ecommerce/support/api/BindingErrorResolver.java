package com.example.ecommerce.support.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import javax.validation.Path.Node;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class BindingErrorResolver {

	private static final String TYPE_MISS_MATCH_MESSAGE = "Type 매칭 실패";

	private BindingErrorResolver() {
		throw new UnsupportedOperationException();
	}

	public static List<BindingError> resolveFrom(final ConstraintViolationException ex) {
		return ex.getConstraintViolations().stream()
				.map(
						violation -> {
							String field = null;
							for (Node node : violation.getPropertyPath()) {
								field = node.getName();
							}

							return new BindingError(field, violation.getMessage());
						})
				.collect(Collectors.toList());
	}

	public static List<BindingError> resolveFrom(final BindException ex) {
		return ex.getBindingResult().getFieldErrors().stream()
				.map(
						error -> {
							String reason =
									error.contains(TypeMismatchException.class)
											? TYPE_MISS_MATCH_MESSAGE
											: error.getDefaultMessage();

							return new BindingError(error.getField(), reason);
						})
				.collect(Collectors.toList());
	}

	public static List<BindingError> resolveFrom(final MethodArgumentTypeMismatchException ex) {
		return List.of(new BindingError(ex.getName(), ex.getMessage()));
	}

	public static List<BindingError> resolveFrom(final MissingServletRequestParameterException ex) {
		return List.of(new BindingError(ex.getParameterName(), ex.getLocalizedMessage()));
	}
}
