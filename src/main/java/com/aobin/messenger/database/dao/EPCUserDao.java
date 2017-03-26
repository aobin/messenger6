package com.aobin.messenger.database.dao;

import com.aobin.messenger.database.entities.EPCUser;

import java.util.List;

public interface EPCUserDao
{

  public EPCUser getUserByEmail(String email);


  public List<EPCUser> getAllUsers();

}
