package com.demo.walet.transactionhistory.models.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "wallet_master")
public class Wallet {
    @Id
    @Column(name="wallet_id_pk")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int walletId;
    @Column(name="first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "currency")
    private String currency;
    @Column(name ="created_time" , nullable = false, updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

}

/*
CREATE TABLE wallet_master (
  wallet_id_pk INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  currency VARCHAR(10) DEFAULT 'INR',
  created_time TIMESTAMP
);
 */
