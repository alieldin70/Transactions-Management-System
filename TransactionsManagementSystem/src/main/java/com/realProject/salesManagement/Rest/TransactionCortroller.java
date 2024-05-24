package com.realProject.salesManagement.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realProject.salesManagement.Entity.ClinetTransactionDetails;
import com.realProject.salesManagement.Entity.Transactions;
import com.realProject.salesManagement.Service.Servicee;

@RestController
@RequestMapping("/transactions")
public class TransactionCortroller {
@Autowired
	private Servicee Servicee;
	@GetMapping
	List<ClinetTransactionDetails> getAllTransactionDetails() {
		List<ClinetTransactionDetails> trLis = Servicee.getAllTransactionDetails();
		return trLis;
	}

	@GetMapping("/{id}")
	ClinetTransactionDetails getTransactionDetails(@PathVariable int id) {
		Optional<ClinetTransactionDetails> tr = Servicee.getTransactionDetails(id);
		ClinetTransactionDetails trr = tr.get();
		return trr;
	}

	@PostMapping
	public Transactions AddTransaction(@RequestBody Transactions t) {

		Transactions savedTransaction = Servicee.addTransaction(t);

		return savedTransaction;
	}

	@PostMapping("/manytransactions")
	public List<Transactions> AddmanyTransactions(@RequestBody List<Transactions> tlis) {

		List<Transactions> savedTransactions = Servicee.addManyTransactions(tlis);

		return savedTransactions;
	}

	@DeleteMapping("/{id}")
	String deleteTransactionById(@PathVariable int id) {
		Servicee.deleteTransactionsById(id);
		return "transaction deleted";
	}

}
