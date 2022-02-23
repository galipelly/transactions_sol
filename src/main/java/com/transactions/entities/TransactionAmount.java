package com.transactions.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSACTION_AMOUNT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionAmount {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "TRANSACTION_AMOUNT")
	private BigDecimal transactionAmount;
	
}
