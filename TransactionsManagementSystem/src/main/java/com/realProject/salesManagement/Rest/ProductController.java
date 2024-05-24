package com.realProject.salesManagement.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realProject.salesManagement.Entity.Product;
import com.realProject.salesManagement.ExcpHand.IdNotFoundException;
import com.realProject.salesManagement.Service.Servicee;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private Servicee Servicee;

	void IdProChecking(int id) {
		// checking if the entered value is number
		int parsedId = Integer.valueOf(id);
		Product product = Servicee.getProductById(parsedId);
		// checking if the client is exist
		if (product == null) {
			throw new IdNotFoundException("in-valid Product Id");
		}
	}

	@GetMapping
	public List<Product> AllProducts() {
		List<Product> ProductList = Servicee.getAllProducts();
		return ProductList;
	}

	@GetMapping("/search/{category}")
	public List<Product> searchByCategory(@PathVariable String category) {
		List<Product> ProductList = Servicee.searchbycategory(category);
		return ProductList;
	}

	@GetMapping("/{id}")
	public Product getProductByid(@PathVariable int id) {
		Product product = Servicee.getProductById(id);
		return product;
	}

	@PostMapping
	public Product addNewProduct(@RequestBody Product newProduct) {
		Product Product = Servicee.addProduct(newProduct);
		return Product;
	}

	@PostMapping("/manyproducts")
	public List<Product> addNewProducts(@RequestBody List<Product> newProducts) {
		List<Product> Products = Servicee.addManyProducts(newProducts);
		return Products;
	}

	@PutMapping
	public Product UpdateProduct(@RequestBody Product UpdatedProduct) {
		IdProChecking(UpdatedProduct.getId());
		Product newupdatedProduct = Servicee.addProduct(UpdatedProduct);
		return newupdatedProduct;
	}

	@DeleteMapping("/{id}")
	public String delectProduct(@PathVariable int id) {
		IdProChecking(id);
		Servicee.deleteProductById(id);

		return "product deleted";
	}

	@DeleteMapping
	public String delectAllProduct() {

		Servicee.deleteProducts();

		return "all products deleted";
	}
}
