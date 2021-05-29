package com.demo.walet.transactionhistory.models.dto.request;

import com.demo.walet.transactionhistory.models.dto.PageInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Data
public class TransactionHistoryRequest {

    @NotNull(message = "invalid wallet")
    @Positive(message = "invalid wallet")
    Integer walletId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date StartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date EndDate;
    PageInfo pageInfo;
}
