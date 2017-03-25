package com.aobin.messenger;

import com.aobin.messenger.models.Student;
import com.aobin.messenger.services.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyResource
{

  StudentService studentService = new StudentService();
  
  @GET
  @Path("/student/{id}")
  public Student getStudent(@PathParam("id") long id)
  {
    
    return studentService.getStudent(id);
  }

  @GET
  @Path("/students")
  public List<Student> getStudents(@HeaderParam("name") String name,@CookieParam("locale") String locale)
  {
    System.out.println("name:"+name);

    System.out.println("locale:"+ locale);
    return studentService.getStudents();
  }
 
 
}
