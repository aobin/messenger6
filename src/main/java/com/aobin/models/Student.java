package com.aobin.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student extends BaseModel
{

  private String name;
  private int age;
  private Date birthDate;

  public Student()
  {
    super();
  }

  public Student(long id, String name, int age)
  {
    super(id);
    this.name = name;
    this.age = age;
    this.birthDate = new Date();
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public Date getBirthDate()
  {
    return birthDate;
  }

  public void setBirthDate(Date birthDate)
  {
    this.birthDate = birthDate;
  }

}
