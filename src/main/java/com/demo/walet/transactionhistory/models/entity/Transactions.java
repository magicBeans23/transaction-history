package com.demo.walet.transactionhistory.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "transactions")
@AllArgsConstructor
public class Transactions {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="tx_id")
    private int transactionId;
    @Column(name="wallet_id")
    @JsonIgnore
    private int walletId;
    @Column(name="transaction_type")
    private int transactiontype; //0-debit, 1-credit
    @Column(name="amount")
    private double amount;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="tx_time", nullable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("transaction time")
    private Date transactionTimestamp;  //for simplicity keeping it as insertion timestamp
}

/*
CREATE TABLE transactions (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  tx_id INT NOT NULL,
  wallet_id INT NOT NULL,
  transaction_type INT NOT NULL,
  amount DOUBLE NOT NULL,
  tx_time TIMESTAMP
);
 */
