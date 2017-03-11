package com.aobin.messenger;

import com.aobin.messenger.models.Student;
import com.aobin.messenger.services.StudentService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource
{

  StudentService studentService = new StudentService();
  
  @GET
  @Path("/student/{id}")
  @Produces(MediaType.APPLICATION_XML)
  public Student getStudent(@PathParam("id") long id)
  {
    
    
    
    return studentService.getStudent(id);
  }
  

 
 
}
