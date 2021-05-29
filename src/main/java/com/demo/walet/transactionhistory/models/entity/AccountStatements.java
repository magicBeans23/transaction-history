package com.demo.walet.transactionhistory.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "account_statement")
@AllArgsConstructor
public class AccountStatements {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    @Column(name = "wallet_id")
    private int walletId;
    @Column(name = "stmt_date")
    @UpdateTimestamp
    private Date stmtDate;
    @Column(name="balance")
    private double balance;

            /*CREATE TABLE account_statement (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  wallet_id INT NOT NULL,
  stmt_date DATE NOT NULL,
  balance DOUBLE NOT NULL


);*/

}
