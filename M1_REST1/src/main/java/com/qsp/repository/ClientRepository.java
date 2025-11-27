package com.qsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qsp.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
     boolean existsByEmail(String email);
}
