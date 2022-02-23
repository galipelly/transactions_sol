package com.transactions.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSACTIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "TRANSACTION_DATE")
	private LocalDate transactionDate;

	@OneToOne(cascade = CascadeType.ALL)
	private TransactionAmount transactionAmount;
	
}
