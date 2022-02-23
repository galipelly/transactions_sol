package com.transactions.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.transactions.entities.TotalAmount;
import com.transactions.entities.TransactionAmount;
import com.transactions.entities.Transaction;
import com.transactions.repos.TotalAmountRepo;
import com.transactions.repos.TransactionRepo;

@Service
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	private TransactionRepo transactionRepo;

	@Autowired
	private TotalAmountRepo totalAmountRepo;

	@Override
	public void saveTransaction(String userId, LocalDate transactionDate, BigDecimal transactionAmount) {
		transactionRepo.save(Transaction.builder().userId(userId).transactionDate(transactionDate)
				.transactionAmount(TransactionAmount.builder().transactionAmount(transactionAmount).build()).build());
		updateTotalAmount(userId, transactionAmount);
	}

	@Override
	public LocalDate getRecentTransactionDate(String userId) {
		Page<Transaction> transaction = transactionRepo.getLatestTransaction(userId, PageRequest.of(0, 1));
		return transaction.getSize() > 0 ? transaction.getContent().get(0).getTransactionDate() : null;
	}

	@Override
	public BigDecimal getLastTransactionAmount(String userId) {
		Page<Transaction> transaction = transactionRepo.getLatestTransaction(userId, PageRequest.of(0, 1));
		return transaction.getSize() > 0 ? transaction.getContent().get(0).getTransactionAmount().getTransactionAmount() : null;
	}

	@Override
	public BigDecimal getTotlaAmount(String userId) {
		Optional<TotalAmount> totalAmount = totalAmountRepo.findById(userId);
		return totalAmount.isPresent() ? totalAmount.get().getTotalAmount() : BigDecimal.ZERO;
	}

	private void updateTotalAmount(String userId, BigDecimal transactionAmount) {
		Optional<TotalAmount> totalAmount = totalAmountRepo.findById(userId);
		if (totalAmount.isPresent()) {
			TotalAmount updatabaleObj = totalAmount.get();
			updatabaleObj.setTotalAmount(updatabaleObj.getTotalAmount().add(transactionAmount));
			totalAmountRepo.save(updatabaleObj);
		} else {
			totalAmountRepo.save(TotalAmount.builder().userId(userId).totalAmount(transactionAmount).build());
		}
	}

}
