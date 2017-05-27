package com.aobin.messenger.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseModel
{

  private String name;
  private int age;
  private Date birthDate;
}
