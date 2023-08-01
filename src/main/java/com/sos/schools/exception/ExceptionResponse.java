package com.sos.schools.exception;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ExceptionResponse {

    private Map<String, String> errors;
    private String requestUrl;
}
