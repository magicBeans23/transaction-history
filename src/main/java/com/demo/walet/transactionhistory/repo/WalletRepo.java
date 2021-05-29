package com.demo.walet.transactionhistory.repo;

import com.demo.walet.transactionhistory.models.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Integer> {

    @Override
    Wallet getOne(Integer integer);


}
