package dev.ericksuarez.simple.api.error;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class ErrorResponse {
    private int status;
    private String error;
}
