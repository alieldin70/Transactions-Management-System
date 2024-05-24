package com.realProject.salesManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realProject.salesManagement.Dao.ProductJparepo;
import com.realProject.salesManagement.Dao.TransactionJpaRepo;
import com.realProject.salesManagement.Dao.TrsnsactionDetailsJpaRepo;
import com.realProject.salesManagement.Dao.clientJpaRpos;
import com.realProject.salesManagement.Entity.Client;
import com.realProject.salesManagement.Entity.ClinetTransactionDetails;
import com.realProject.salesManagement.Entity.Product;
import com.realProject.salesManagement.Entity.Transactions;
import com.realProject.salesManagement.ExcpHand.IdNotFoundException;

@Service
public class ServiceImpl implements Servicee {
	// dependency injection
	@Autowired
	private clientJpaRpos clientJpaRpos;
	@Autowired
	private ProductJparepo ProductJparepo;
	@Autowired
	private TransactionJpaRepo transactionJpaRepo;
	@Autowired
	private TrsnsactionDetailsJpaRepo transactionDetailsJpaRepo;

//---------------Client------------------
	@Override
	public List<Client> getAllClients() {
		List<Client> allClients = clientJpaRpos.findAll();
		return allClients;
	}

	@Override
	public Client getClientById(int id) {
		// checking if the entered value is number
		int parsedId = Integer.valueOf(id);
		Optional<Client> client = clientJpaRpos.findById(parsedId);
		// checking if the client is exist
		if (!client.isPresent()) {
			throw new IdNotFoundException("in-valid Client Id");
		}
		Client parseClient = client.get();
		return parseClient;
	}

	@Override
	public Client addClient(Client newCl) {
		Client client = clientJpaRpos.save(newCl);
		return client;
	}

	@Override
	public void deleteClientById(int id) {
		clientJpaRpos.deleteById(id);
	}

	// ---------------Product------------------
	@Override
	public List<Product> getAllProducts() {
		List<Product> allProducts = ProductJparepo.findAll();
		return allProducts;
	}

	@Override
	public Product getProductById(int id) {

		// checking if the entered value is number
		int parsedId = Integer.valueOf(id);
		Optional<Product> Product = ProductJparepo.findById(parsedId);
		// checking if the client is exist
		if (!Product.isPresent()) {
			throw new IdNotFoundException("in-valid Client Id");
		}
		Product parseProduct = Product.get();
		return parseProduct;
	}

	@Override
	public Product addProduct(Product newProduct) {
		Product Product = ProductJparepo.save(newProduct);
		return Product;
	}

	@Override
	public List<Product> addManyProducts(List<Product> prLis) {
		List<Product> productList = ProductJparepo.saveAll(prLis);
		return productList;
	}

	@Override
	public void deleteProductById(int id) {
		ProductJparepo.deleteById(id);

	}

	@Override
	public void deleteProducts() {
		ProductJparepo.deleteAll();

	}

	@Override
	public List<Product> searchbycategory(String category) {

		List<Product> items = ProductJparepo.findByCategory(category);
		return items;
	}
	// ---------------transactions------------------

	@Override
	public Transactions addTransaction(Transactions t) {
		// search that client is exist
		Optional<Client> client = clientJpaRpos.findById(t.getClientId());
		if (!client.isPresent()) {
			throw new IdNotFoundException("in-valid Client Id");
		}
		Optional<Product> Product = ProductJparepo.findById(t.getProductId());
		if (!Product.isPresent()) {
			throw new IdNotFoundException("in-valid Product Id");
		}
		// checking if the product quantity is available or not
		Product extractPro = Product.get();
		if (extractPro.getAvailable_quantity() < t.getQuantity() || t.getQuantity() < 0) {
			throw new RuntimeException("product out of stock");
		}
		extractPro.setAvailable_quantity(extractPro.getAvailable_quantity() - t.getQuantity());
		ProductJparepo.save(extractPro);
		Transactions savedTransactions = transactionJpaRepo.save(t);

		return savedTransactions;
	}

	@Override
	public List<Transactions> addManyTransactions(List<Transactions> trLis) {
		// search that client is exist
		for (Transactions t : trLis) {
			Optional<Client> client = clientJpaRpos.findById(t.getClientId());
			if (!client.isPresent()) {
				throw new IdNotFoundException("in-valid Client Id");
			}
			Optional<Product> Product = ProductJparepo.findById(t.getProductId());
			if (!Product.isPresent()) {
				throw new IdNotFoundException("in-valid Product Id");
			}
			Product extractPro = Product.get();
			if (extractPro.getAvailable_quantity() < t.getQuantity() || t.getQuantity() < 0) {
				throw new RuntimeException("product out of stock");
			}
			extractPro.setAvailable_quantity(extractPro.getAvailable_quantity() - t.getQuantity());
			ProductJparepo.save(extractPro);
		}
		List<Transactions> savedLis = transactionJpaRepo.saveAll(trLis);

		return savedLis;
	}

	@Override
	public void deleteTransactionsById(int id) {

		transactionJpaRepo.deleteById(id);
	}

	@Override
	public List<ClinetTransactionDetails> getAllTransactionDetails() {
		List<ClinetTransactionDetails> transacationsDetails = transactionDetailsJpaRepo.findAll();
		return transacationsDetails;
	}

	@Override
	public Optional<ClinetTransactionDetails> getTransactionDetails(int id) {
		Optional<ClinetTransactionDetails> transacationDetails = transactionDetailsJpaRepo.findById(id);
		if (!transacationDetails.isPresent()) {
			throw new IdNotFoundException("in-valid transaction Id");
		}

		return transacationDetails;
	}

}
