package com.pm.adapter.controller;

import com.pm.adapter.exception.NoAccountFoundException;
import com.pm.adapter.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static com.pm.adapter.testutil.TestData.buildAccounts;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void testGetAccounts_Ok() throws Exception {
        when(accountService.getAccounts()).thenReturn(buildAccounts());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accounts");

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testGetAccounts_NoAccount() throws Exception {
        when(accountService.getAccounts()).thenThrow(new NoAccountFoundException("No account found."));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accounts");

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(404, mvcResult.getResponse().getStatus());
    }

}
