package com.aobin.database.migration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFlyway extends Flyway
{

    public static enum RESULT
    {
        SUCCESS, ERROR
    }

    private Logger logger = LogManager.getLogger(MyFlyway.class);
    private String separator = getSeparator();

    public void myMigrate()
    {
        try
        {
            this.migrate();
            logger.info("flyway execute successfully!");
            generateFile(getFileName(RESULT.SUCCESS),"");
        }
        catch (FlywayException e)
        {
            logger.info("flyway execute failed!");
            generateFile(getFileName(RESULT.ERROR),e.getMessage());
            throw e;
        }
    }

    // FILE_NAME: SUCCESS_20170531_hhmiss
    public String getFileName(RESULT result)
    {
        String fileName = "";
        String fileDirectoryStr = separator + "flyway" + separator;
        File fileDirectory = new File(fileDirectoryStr);
        if (!fileDirectory.exists())
        {
            fileDirectory.mkdirs();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String dateStr = dateFormat.format(new Date());

        if (result == RESULT.ERROR)
        {
            fileName = fileDirectoryStr + String.format("ERROR_%s", dateStr);
        }

        if (result == RESULT.SUCCESS)
        {
            fileName = fileDirectoryStr + String.format("SUCCESS_%s", dateStr);
        }

        return fileName;
    }

    public void generateFile(String fileName, String fileContent)
    {
        File file = new File(fileName);
        FileOutputStream fileOutputStream = null;
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
                byte[] fileContentInByte = fileContent.getBytes();
                fileOutputStream.write(fileContentInByte);
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            catch (IOException e)
            {
                logger.error("create flyway file failed! Exception:" + e.getMessage());
            }
            finally
            {
                try
                {
                    if (fileOutputStream != null)
                    {
                        fileOutputStream.close();
                    }
                }
                catch (IOException e)
                {
                    logger.error("close flyway file failed. Exception:" + e.getMessage());
                }
            }
        }
    }

    private String getSeparator()
    {
        return System.getProperty("file.separator");
    }

    public static void main(String[] args)
    {
        MyFlyway myFlyway = new MyFlyway();

        String fileName = myFlyway.getFileName(RESULT.ERROR);
        System.out.println(fileName);
        String separator = System.getProperty("file.separator");
        System.out.println(separator);

        myFlyway.generateFile(fileName, "123123");
    }

}
