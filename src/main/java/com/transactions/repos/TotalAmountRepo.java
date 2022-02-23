package com.transactions.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transactions.entities.TotalAmount;

public interface TotalAmountRepo extends JpaRepository<TotalAmount, String> {

}
