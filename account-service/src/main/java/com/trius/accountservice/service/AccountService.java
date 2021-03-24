package com.trius.accountservice.service;

import com.trius.accountservice.entity.Account;
import com.trius.accountservice.repo.AccountRepository;
import com.trius.contract.AccountDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;


    public AccountDto get(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        return modelMapper.map(account, AccountDto.class);
    }

    @Transactional
    public AccountDto save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account.setId(UUID.randomUUID().toString());
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Transactional
    public AccountDto update(String id, AccountDto accountDto) {
        Assert.isNull(id, "Id cannot be null");
        Optional<Account> account = accountRepository.findById(id);
        Account accountToUpdate = account.map(it -> {
            it.setEmail(accountDto.getEmail());
            it.setUsername(accountDto.getUsername());
            return it;
        }).orElseThrow(NotFoundException::new);
        return modelMapper.map(accountRepository.save(accountToUpdate), AccountDto.class);
    }

    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        accountRepository.delete(account);
    }

    public Slice<AccountDto> findAll(Pageable pageable) {
        Slice<Account> accounts = accountRepository.findAll(pageable);
        return null;
    }

    public List<AccountDto> getAll() {
        List<Account> accounts = accountRepository.findAll();
        return null;
    }
}
