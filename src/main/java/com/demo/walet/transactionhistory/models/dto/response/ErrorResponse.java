package com.demo.walet.transactionhistory.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public final class ErrorResponse {
    private final String errorCode;
    private final String errortext;
}
