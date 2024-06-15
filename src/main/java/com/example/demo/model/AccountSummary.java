package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Data
@Table(name="accountsummary")
public class AccountSummary {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountNumber;
    private double balance;

    @OneToMany(mappedBy = "accountSummary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> recentTransactions;
}
