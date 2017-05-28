package com.aobin.database.migration;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

public class MyFlyway extends Flyway
{

    public void myMigrate()
    {

        try
        {
            this.migrate();
        }
        catch (FlywayException e )
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}
