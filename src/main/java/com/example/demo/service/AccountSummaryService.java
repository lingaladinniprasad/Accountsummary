package com.example.demo.service;

//package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.AccountSummary;
import com.example.demo.repository.AccountSummaryRepository;


import java.util.List;
import java.util.Optional;

@Service
public class AccountSummaryService {

    @Autowired
    private AccountSummaryRepository repository;

    public Optional<AccountSummary> getAccountSummary(Long id) {
        return repository.findById(id);
    }

    public AccountSummary createAccountSummary(AccountSummary accountSummary) {
        return repository.save(accountSummary);
    }
    //getAllAccounts
    public List<AccountSummary> getAllAccountDetails() {
		 List<AccountSummary> ListofAccounts=repository.findAll();
		return ListofAccounts;
	}
    //deposit amount
    public AccountSummary depositAmount(Long id, Double amount) {
  	  Optional<AccountSummary> account =  repository.findById( id);
  	  if(account.isEmpty()) {
  		  throw new RuntimeException("Account is not present");
  	  }
  	  AccountSummary accountPresent=account.get();
  	 Double totalBalance=accountPresent.getBalance()+amount;

          accountPresent.setBalance(totalBalance);
          repository.save(accountPresent);
  		return accountPresent;
  	}

  	//withdraw amount
  	public AccountSummary withdrawAmount(Long id, Double amount) {
  		 Optional<AccountSummary> account =  repository.findById( id);
  		  if(account.isEmpty()) {
  			  throw new RuntimeException("Account is not present");
  		  }
  		  AccountSummary accountPresent=account.get();
  		

  	      Double accountalance= accountPresent.getBalance()-amount;
  	        repository.save(accountPresent);
  	        accountPresent.setBalance(accountalance);
  			
  		repository.save(accountPresent);
  		return  accountPresent;
  	}
  	//closeAccount
  	public void closeAccount(Long id) {
		   getAccountDetailsByaccountNumber(id);
		   repository.deleteById(id);
	}

	private void getAccountDetailsByaccountNumber(Long accountNumber) {
		// TODO Auto-generated method stub
		
	}

}
