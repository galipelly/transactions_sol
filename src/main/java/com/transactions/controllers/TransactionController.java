package com.transactions.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.transactions.models.TransactionRequest;
import com.transactions.services.TransactionsService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionsService transactionService;

	@GetMapping
	public String greetingForm(Model model) {
		model.addAttribute("body", new TransactionRequest());
		return "index";
	}

	@PostMapping("/save")
	public ResponseEntity<Void> saveTransaction(@ModelAttribute TransactionRequest body, Model model) {
		model.addAttribute("body", body);
		transactionService.saveTransaction(body.getUserId(), LocalDate.parse(body.getTransactionDate()),
				body.getTransactionAmount());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/getRecentTransactionDate/{userId}")
	public ResponseEntity<LocalDate> getRecentTransactionDate(@PathParam("userId") String userId, Model model) {
		LocalDate recentTransactionDate = transactionService.getRecentTransactionDate(userId);
		model.addAttribute("recentTransactionDate", recentTransactionDate);
		return new ResponseEntity<LocalDate>(recentTransactionDate, HttpStatus.OK);
	}

	@GetMapping("/getLastTransactionAmount/{userId}")
	public ResponseEntity<BigDecimal> getLastTransactionAmount(@PathParam("userId") String userId, Model model) {
		BigDecimal lastTransactionAmount = transactionService.getLastTransactionAmount(userId);
		model.addAttribute("lastTransactionAmount", lastTransactionAmount);
		return new ResponseEntity<BigDecimal>(lastTransactionAmount, HttpStatus.OK);
	}

	@GetMapping("/getTotlaAmount/{userId}")
	public ResponseEntity<BigDecimal> getTotlaAmount(@PathParam("userId") String userId, Model model) {
		BigDecimal totalAmount = transactionService.getTotlaAmount(userId);
		model.addAttribute("totalAmount", totalAmount);
		return new ResponseEntity<BigDecimal>(totalAmount, HttpStatus.OK);
	}

}
