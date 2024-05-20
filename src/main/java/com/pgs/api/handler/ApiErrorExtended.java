package com.pgs.api.handler;

import java.util.HashMap;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ApiErrorExtended {
	/** The error code. */
	@NotBlank(message = "Error Code is mandatory")
	@JsonProperty("errorCode")
	private final ErrorCode errorCode;

	/** The message. */
	@NotBlank(message = "Message is mandatory")
	@JsonProperty("message")
	private final String message;

	/** The errors. */
	@JsonProperty("errors")
	private final List<HashMap<Object, String>> errors;
}