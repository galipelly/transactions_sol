package com.transactions.services;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TransactionsService {

	void saveTransaction(String userId, LocalDate transactionDate, BigDecimal transactionAmount);
	
	LocalDate getRecentTransactionDate(String userId);
	
	BigDecimal getLastTransactionAmount(String userId);
	
	BigDecimal getTotlaAmount(String userId);
	
}
