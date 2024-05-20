package com.pgs.api.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration of error codes.
 */
@AllArgsConstructor
@Getter
public enum ArchErrorCode implements ErrorCode {

	/** The tech 001. */
	TECH_001("Validation error"),
	
	/** The tech 001. */
	TECH_002("The maximum number of slogans have been reached");

	/** The reason phrase. */
	private final String reasonPhrase;
}
