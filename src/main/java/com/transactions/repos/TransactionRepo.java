package com.transactions.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.transactions.entities.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

	
	@Query("FROM Transaction t WHERE t.userId = :userId ORDER BY t.transactionDate DESC")
	Page<Transaction> getLatestTransaction(String userId, Pageable page);
	
}
