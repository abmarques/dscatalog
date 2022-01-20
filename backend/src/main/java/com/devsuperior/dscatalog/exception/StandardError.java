package com.devsuperior.dscatalog.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class StandardError {

    private Integer status;
    private String message;
    private String path;
    private Instant timestamp;
}
