package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserUnitTest {

private static AnnotationConfigApplicationContext context;
static UserDAO userDAO;

@BeforeClass
public static void executeFirst()throws Exception
{
context=new AnnotationConfigApplicationContext();
context.scan("com.niit");
context.refresh();

userDAO=(UserDAO)context.getBean("userDAO");
}


@Test
public void registerUser()
{
User ud=new User();
ud.setUsername("Sujit");
ud.setPassword("945");
ud.setRole("user");
ud.setEnabled(true);
ud.setCustomerName("SKS");
ud.setMobileNo("09452146347");
ud.setEmailId("sujitspike1@gmail.com");
ud.setAddress("Indira Nagar,Lucknow");
assertTrue("Problem in UserDetail Insertion",userDAO.registerUser(ud));

}

@Ignore
@Test
public void updateDetail()
{
User ud=new User();
ud.setCustomerName("Singh");

}
}