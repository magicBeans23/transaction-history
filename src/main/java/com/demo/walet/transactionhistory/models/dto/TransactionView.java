package com.demo.walet.transactionhistory.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class TransactionView {

    @JsonProperty("transaction id")
    private final Integer transactionId;

    @JsonProperty("type")
    private final String transactiontype; //0-debit, 1-credit
    @JsonProperty("amount")
    private final Double amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("transaction time")
    private final Date transactionTimestamp;  //for simplicity keeping it as insertion timestamp
}
