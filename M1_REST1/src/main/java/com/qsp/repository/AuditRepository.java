package com.qsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.entity.Audit;

public interface AuditRepository extends JpaRepository<Audit, String>{
}
