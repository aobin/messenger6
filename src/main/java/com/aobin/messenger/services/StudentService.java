package com.aobin.messenger.services;


import com.aobin.messenger.database.DataBase;
import com.aobin.messenger.models.Student;

public class StudentService
{
  private DataBase<Student> studentDatabase=new DataBase<>();
  
  public StudentService()
  {
    Student student1=new Student(1, "aobin1", 11);
    Student student2=new Student(2, "aobin2", 22);
    Student student3=new Student(3, "aobin3", 33);
    studentDatabase.addEntity(student1);
    studentDatabase.addEntity(student2);
    studentDatabase.addEntity(student3);   
  }
  
  public Student getStudent(long id)
  {
    Student student = studentDatabase.getEntity(id);
    
    return student;
  }

}
