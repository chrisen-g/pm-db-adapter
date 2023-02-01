package com.pm.adapter.testutil;

import com.pm.adapter.dto.AccountDto;
import com.pm.adapter.model.Account;

import java.util.Arrays;
import java.util.List;

public class TestData {

    public static List<AccountDto> buildAccounts() {
        AccountDto account1 = new AccountDto("1", "BPU", "ATM", 1000.0f);
        AccountDto account2 = new AccountDto("1", "BDO", "ATM", 1000.0f);

        return Arrays.asList(account1, account2);
    }


}
