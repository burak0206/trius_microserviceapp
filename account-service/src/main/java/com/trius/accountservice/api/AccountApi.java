package com.trius.accountservice.api;

import com.trius.accountservice.service.AccountService;
import com.trius.contract.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * localhost:8080/account
 * GET PUT DELETE POST
 */
@RestController
@RequestMapping("account")
public class AccountApi {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountService.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Slice<AccountDto>> all(Pageable pageable) {
        return ResponseEntity.ok(accountService.findAll(pageable));

    }

    @GetMapping("/list")
    public ResponseEntity<List<AccountDto>> list( ) {
        return ResponseEntity.ok(accountService.getAll());

    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping
    public ResponseEntity<AccountDto> update(@PathVariable("id") String id, @RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.update(id, account));
    }

    @DeleteMapping
    public void delete(String id) {
        accountService.delete(id);
    }

}
