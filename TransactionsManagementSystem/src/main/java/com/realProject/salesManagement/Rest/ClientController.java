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

import com.realProject.salesManagement.Entity.Client;
import com.realProject.salesManagement.ExcpHand.IdNotFoundException;
import com.realProject.salesManagement.Service.Servicee;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private Servicee Servicee;
	// for check if the id is exist and valid
	void IdChecking(int id) {
		// checking if the entered value is number
		int parsedId = Integer.valueOf(id);
		Client client = Servicee.getClientById(parsedId);
		// checking if the client is exist
		if (client == null) {
			throw new IdNotFoundException("in-valid Client Id");
		}

	}
//retriving all clients 
	@GetMapping
	public List<Client> AllClients() {
		List<Client> clientList = Servicee.getAllClients();
		return clientList;
	}

// retreiving client by id 
	@GetMapping("/{id}")
	public Client getClientByid(@PathVariable int id) {

		Client client = Servicee.getClientById(id);

		return client;
	}

// add new client
	@PostMapping
	public Client addNewClient(@RequestBody Client newclient) {
		Client client = Servicee.addClient(newclient);
		return client;
	}

//update an existing client
	@PutMapping
	public Client UpdateClient(@RequestBody Client newclient) {
		IdChecking(newclient.getId());
		Client updatedclient = Servicee.addClient(newclient);
		return updatedclient;
	}

	// delete an existing client
	@DeleteMapping("/{id}")
	public String delectClient(@PathVariable int id) {
		IdChecking(id);
		Servicee.deleteClientById(id);

		return "Client deleted";
	}

	{

	}
}
