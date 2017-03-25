package com.aobin.messenger.database;

import com.aobin.messenger.models.BaseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    this.mapDataBase.put(new Long(this.mapDataBase.size()+1), entity);
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

  public List<T> getEntities()
  {
    List<Long> keys = new ArrayList<>(this.mapDataBase.keySet());

    List<T> entityList = new ArrayList<T>();
    for(Long key: keys)
    {
        entityList.add(this.mapDataBase.get(key));
    }
     return entityList;
  }

}
