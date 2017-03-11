package com.aobin.messenger.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseModel
{
  private long id;

  public BaseModel()
  {

  }
  
  public BaseModel(long id)
  {
    this.id=id;
  }
  
  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }
  
  
  
}
