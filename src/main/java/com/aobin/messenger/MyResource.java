package com.aobin.messenger;

import com.aobin.messenger.database.dao.EPCUserDao;
import com.aobin.messenger.database.entities.EPCUser;
import com.aobin.messenger.models.Student;
import com.aobin.messenger.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyResource
{

    StudentService studentService = new StudentService();
    private EPCUserDao epcUserDao;

    @Autowired
    public MyResource(EPCUserDao epcUserDao)
    {
        this.epcUserDao = epcUserDao;
    }

    @GET
    @Path("/student/{id}")
    public Student getStudent(@PathParam("id") long id)
    {
        EPCUser epcUser = epcUserDao.getUserByEmail("aobin");
        System.out.println(epcUser.getEmail());
        return studentService.getStudent(id);
    }

    @GET
    @Path("/students")
    public List<Student> getStudents(@HeaderParam("name") String name, @CookieParam("locale") String locale)
    {
        System.out.println("name:" + name);

        System.out.println("locale:" + locale);
        return studentService.getStudents();
    }

}
