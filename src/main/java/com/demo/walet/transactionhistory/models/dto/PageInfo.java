package com.demo.walet.transactionhistory.models.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public class PageInfo {
    @ApiModelProperty(value = "page", example="0")
    @NotNull(message = "page no cannot be null")
    @PositiveOrZero(message = "page no must be positive")
    private Integer page;
    @Positive(message = "page size must be greater than 0")
    @NotNull(message = "page size cannot be null")
    private Integer size;
    @ApiModelProperty(value="sortField", example="transactionTimestamp", allowEmptyValue = true)
    private String sortField;
    @ApiModelProperty(value = "sortType", example = "asc", allowEmptyValue = true)
    private String sortType;
}
