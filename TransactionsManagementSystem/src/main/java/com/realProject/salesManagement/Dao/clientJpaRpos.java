package com.realProject.salesManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realProject.salesManagement.Entity.Client;

public interface clientJpaRpos extends JpaRepository<Client ,Integer> {
 
}
