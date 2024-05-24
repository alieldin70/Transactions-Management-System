/**
 * 
 */
package com.realProject.salesManagement.Service;

import java.util.List;
import java.util.Optional;

import com.realProject.salesManagement.Entity.Client;
import com.realProject.salesManagement.Entity.ClinetTransactionDetails;
import com.realProject.salesManagement.Entity.Product;
import com.realProject.salesManagement.Entity.Transactions;

public interface Servicee {
//------------------------------	
//client services 
	List<Client> getAllClients();

	Client getClientById(int id);

	Client addClient(Client newCl);

	void deleteClientById(int id);

//------------------------------
//product services
	List<Product> getAllProducts();

	Product getProductById(int id);

	List<Product> searchbycategory(String category);

	Product addProduct(Product newProduct);

	List<Product> addManyProducts(List<Product> prLis);

	void deleteProductById(int id);

	void deleteProducts();

//------------------------------
//Transactions services
	Transactions addTransaction(Transactions t);

	List<Transactions> addManyTransactions(List<Transactions> trLis);

	void deleteTransactionsById(int id);

	List<ClinetTransactionDetails> getAllTransactionDetails();

	Optional<ClinetTransactionDetails> getTransactionDetails(int id);
}
