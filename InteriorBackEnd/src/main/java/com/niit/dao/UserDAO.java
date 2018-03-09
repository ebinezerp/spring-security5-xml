package com.niit.dao;

import com.niit.model.User;

public interface UserDAO
{
  public boolean registerUser(User user);
  public boolean updateDetail(User user);
 
}