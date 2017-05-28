package com.aobin.messenger;

import com.aobin.messenger.database.dao.EPCUserDao;
import com.aobin.messenger.database.entities.EPCUser;
import com.aobin.messenger.jms.MessegeProducer;
import com.aobin.messenger.models.Student;
import com.aobin.messenger.services.AsyncService;
import com.aobin.messenger.services.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyResource
{

    @Autowired
    StudentService studentService;
    @Autowired
    AsyncService asyncService;
    @Autowired
    private EPCUserDao epcUserDao;
    @Autowired
    private MessegeProducer messegeProducer;

    @Autowired
    private Destination queueDestination;

    Logger logger = LogManager.getLogger(MyResource.class);

    @GET
    @Path("/student/{id}")
    public EPCUser getStudent(@PathParam("id") long id)
    {
        EPCUser epcUser = epcUserDao.getUserByEmail("aobin");
        System.out.println(epcUser.getEmail() + " 123123123");

        System.out.println("JMS test begin===");
        messegeProducer.sendMessage(queueDestination, "你好，生产者！这是消息：");
        System.out.println("JMS test end===");

        return epcUser;
    }

    @GET
    @Path("/students")
    public List<Student> getStudents(@HeaderParam("name") String name, @CookieParam("locale") String locale)
    {
        System.out.println("name111:" + name);
        System.out.println("哈哈111:" + name);
        System.out.println("locale:" + locale);
        logger.info("hello {}", name);
        logger.info("for test");
        return studentService.getStudents();
    }

    @GET
    @Path("/asyncService/getStringResponseInFuture")
    public String getStringResponseInFuture()
    {
        System.out.println("start to execute controller, send out async request");
        Future<String> future1 = asyncService.getStringResponseInFuture();
        Future<String> future2 = asyncService.getStringResponseInFuture();
        Future<String> future3 = asyncService.getStringResponseInFuture();

        System.out.println("async requests have been sent out, wait for result");
        String result1="";
        String result2="";
        String result3="";

        while (true)
        {
            if (future1.isDone() && future2.isDone() && future3.isDone())
            {
                System.out.println("two requests have been finished!");
                try
                {
                    result1 = future1.get();
                    System.out.println(result1);
                    result2 = future2.get();
                    System.out.println(result2);
                    result3 = future3.get();
                    System.out.println(result3);
                    break;
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                catch (ExecutionException e)
                {
                    e.printStackTrace();
                }

            }

        }

        return "123123";

    }

}
