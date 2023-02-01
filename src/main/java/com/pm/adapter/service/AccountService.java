package com.pm.adapter.service;

import com.pm.adapter.dto.AccountDto;
import com.pm.adapter.model.Account;
import java.util.List;

public interface AccountService {
    List<AccountDto> getAccounts();

}
