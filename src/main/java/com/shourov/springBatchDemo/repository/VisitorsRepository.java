package com.shourov.springBatchDemo.repository;

import com.shourov.springBatchDemo.model.Visitors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorsRepository extends JpaRepository<Visitors, Long> {
}
