package com.aobin.messenger.services;


import com.aobin.messenger.database.DataBase;
import com.aobin.messenger.models.Student;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService
{
  private DataBase<Student> studentDatabase;

  public StudentService()
  {
    studentDatabase=new DataBase<>();
    Student student1=new Student("aobin1", 1, new Date());
    Student student2=new Student("aobin2", 2, new Date());
    Student student3=new Student("aobin3", 3, new Date());
    studentDatabase.addEntity(student1);
    studentDatabase.addEntity(student2);
    studentDatabase.addEntity(student3);   
  }
  
  public Student getStudent(long id)
  {
    Student student = studentDatabase.getEntity(id);
    
    return student;
  }

  public List<Student> getStudents()
  {
    return this.studentDatabase.getEntities();
  }

}
