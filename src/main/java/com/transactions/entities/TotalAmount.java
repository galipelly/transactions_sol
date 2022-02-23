package com.transactions.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TOTAL_AMOUNT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TotalAmount {

	@Id
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "TOTAL_AMOUNT")
	private BigDecimal totalAmount;
}
