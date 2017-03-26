package com.aobin.messenger.database.dao;

import com.aobin.messenger.database.entities.EPCUser;
import com.aobin.messenger.database.repositories.EPCUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EPCUserDaoImpl implements EPCUserDao
{
  
  private EPCUserRepository epcUserRepository;
  

  @Autowired
  public EPCUserDaoImpl(EPCUserRepository repository)
  {
    this.epcUserRepository = repository;
  }

  
  @Override
  public EPCUser getUserByEmail(String email)
  {
    return epcUserRepository.findByEmail(email);
  }

  @Override
  public List<EPCUser> getAllUsers()
  {
    return epcUserRepository.findAll();
  }

}
