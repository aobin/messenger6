package com.aobin.database;

import com.aobin.messenger.models.BaseModel;

import java.util.HashMap;
import java.util.Map;

public class DataBase<T extends BaseModel>
{
  private Map<Long, T> mapDataBase;
  
  public DataBase()
  {
    this.mapDataBase=new HashMap<>();
    
  }
  
  public T addEntity(T entity)
  {
    this.mapDataBase.put(entity.getId(), entity);
    return entity;
  }
  
  public void deleteEntity(long id)
  {
    this.mapDataBase.remove(id);
  }
  
  public T getEntity(long id)
  {
    return this.mapDataBase.get(id);
  }
  
}
