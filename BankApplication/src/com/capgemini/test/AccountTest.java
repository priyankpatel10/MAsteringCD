package com.capgemini.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AccountTest {

	@Mock
	AccountRepository accountRepository;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		AccountService accountService = new AccountServiceImpl(accountRepository);
	
	}
	
	@Test(expected = InsufficientInitialBalanceException.class)
	public void testCreatAccount() throws InsufficientInitialBalanceException
	{
		AccountService accountService = new AccountServiceImpl(accountRepository);
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(1000);
		Mockito.when(accountRepository.save(account)).thenReturn(true);
		//Account acc = accountService.createAccount(123456, 1000);
		assertEquals(account,accountService.createAccount(101, 1000));
		
		
		
		
	}

	
	
}
