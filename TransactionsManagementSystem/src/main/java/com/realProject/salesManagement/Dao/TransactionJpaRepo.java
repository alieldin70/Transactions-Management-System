package com.realProject.salesManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realProject.salesManagement.Entity.Transactions;
public interface TransactionJpaRepo extends JpaRepository<Transactions, Integer> {
}
