package com.pm.adapter.service;

import com.pm.adapter.dto.AccountDto;
import com.pm.adapter.exception.NoAccountFoundException;
import com.pm.adapter.model.Account;
import com.pm.adapter.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private ModelMapper modelMapper;

    @Override
    public List<AccountDto> getAccounts() {
        List<Account> accounts = accountRepository.findAll();

        if (Objects.isNull(accounts) || accounts.isEmpty()) {
            throw new NoAccountFoundException("No account found.");
        }

        List<AccountDto> accountDtos = new ArrayList<>();
        accounts.stream().forEach(
                account -> accountDtos.add(modelMapper.map(account, AccountDto.class)));

        return accountDtos;
    }
}
