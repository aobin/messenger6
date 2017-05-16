package com.aobin.template.jxls;

import com.aobin.messenger.models.Student;
import com.aobin.messenger.services.StudentService;
import com.google.common.io.Resources;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by 敖斌 on 2017/5/14.
 */
public class JxlsTest
{
    private static final Logger logger = LoggerFactory.getLogger(JxlsTest.class);

    private static List<Student> students = new StudentService().getStudents();

    public static void main(String[] args)
    {
        InputStream inputStream = null;
        for(Student student:students)
        {
            System.out.println(student);
        }

        try
        {
            //直接获取resources目录下面的文件,没有/
            inputStream = Resources.getResource("template/xls_template.xlsx").openStream();
            OutputStream os = new FileOutputStream("D:\\xls_template_output.xlsx");
            Context context = new Context();
            context.putVar("students", students);
            context.putVar("message","hello!!");

            JxlsHelper.getInstance().processTemplate(inputStream,os,context);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

}
