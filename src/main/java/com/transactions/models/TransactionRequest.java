package com.transactions.models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TransactionRequest {

	private String userId;
	
	private String transactionDate;
	
	private BigDecimal transactionAmount;
}
