package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.AccountSummary;

public interface AccountSummaryRepository extends JpaRepository<AccountSummary, Long> {
}
