package com.dxc.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.bankapp.entity.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
