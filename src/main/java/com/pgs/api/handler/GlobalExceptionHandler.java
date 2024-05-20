package com.pgs.api.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());
		return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	private Map<String, List<String>> getErrorsMap(List<String> errors) {
		Map<String, List<String>> errorResponse = new HashMap<>();
		errorResponse.put("errors", errors);
		return errorResponse;
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex) {
//		final List<HashMap<Object, String>> errors = new ArrayList<>();
//		final HashMap<Object, String> valores = new HashMap<Object, String>();
//		
//		for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
//			valores.put(error.getField(), error.getDefaultMessage());
//		}
//
//		for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
//			valores.put(error.getObjectName(), error.getDefaultMessage());
//		}
//		
//		if(valores.size() > 0) errors.add(valores);
//
//		final ApiErrorExtended apiError = new ApiErrorExtended(ArchErrorCode.TECH_001, ArchErrorCode.TECH_001.getReasonPhrase(), errors);
//
//		return handleExceptionInternall(ex, apiError, null, BAD_REQUEST, null);
//	}
//	
//	protected ResponseEntity<Object> handleExceptionInternall(
//			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
//			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
//		}
//		return new ResponseEntity<>(body, headers, status);
//	}
}
