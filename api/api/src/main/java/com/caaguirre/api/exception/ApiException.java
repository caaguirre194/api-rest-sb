package com.caaguirre.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ApiException extends Throwable {

    private final String message;

    private final HttpStatus httpStatus;

    private final ZonedDateTime timestamp;

}
