package com.phoebus.kyc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.phoebus.kyc.controller.AccountController;
import com.phoebus.kyc.model.Account;
 
@ExtendWith(MockitoExtension.class)
//@ExtendWith(JUnitPlatform.class)


public class AccountControllerTest 
{
    @InjectMocks
    AccountController accountController;
     
  
    @Test
    public void testAddEmployee() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
         
        Account account = new Account(345L,3939);
        Account accountResponse = accountController.newAccount(account);
         
        assertThat(accountResponse != null);
    }
     
    @Test
    public void testFindAll() 
    {
        List<Account> result = accountController.getAccountsByCustomer(1L);
 
        // then
        assertThat(result.size()).isEqualTo(2);
         
//        assertThat(result.getEmployeeList().get(0).getFirstName())
//                        .isEqualTo(employee1.getFirstName());
//         
//        assertThat(result.getEmployeeList().get(1).getFirstName())
//                        .isEqualTo(employee2.getFirstName());
    }
}