package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.AccountSummary;
import com.example.demo.service.AccountSummaryService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accountSummary")
public class AccountSummaryController {

    @Autowired
    private AccountSummaryService service;

    @GetMapping("/{accountnumber}")
    public ResponseEntity<AccountSummary> getAccountSummary(@PathVariable Long id) {
        Optional<AccountSummary> accountSummary = service.getAccountSummary(id);
        return accountSummary.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/getallaccounts")
    public List<AccountSummary>getAllAccountDetails(){
     List<AccountSummary>allAccountDetails=service.getAllAccountDetails();
     return allAccountDetails;
}

    @PostMapping("/open")
    public ResponseEntity<AccountSummary> createAccountSummary(@RequestBody AccountSummary accountSummary) {
        AccountSummary createdAccountSummary = service.createAccountSummary(accountSummary);
        return ResponseEntity.ok(createdAccountSummary);
    }
    
    // deposit

    @PutMapping("/deposit/{accountnumber}/{amount}")
   public AccountSummary depositAccount( @PathVariable Long id, @PathVariable Double amount) {
 	      AccountSummary account=service.depositAmount(id,amount);
 	   
 	   
 	  return account;
   }
    @PutMapping("/withdraw/{accountnumber}/{amount}")
    public AccountSummary withdrawAccount( @PathVariable Long id, @PathVariable Double amount) {
        AccountSummary account=service.withdrawAmount( id,amount);
        return account;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
 	   service.closeAccount(id);
 	   return ResponseEntity.ok("Account closed");
 	   
    }

    
}
