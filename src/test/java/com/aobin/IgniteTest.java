package com.aobin;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class IgniteTest
{

    private static int age;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        age =10;
    }

    @AfterClass
    public static void setUpAfterClass() throws Exception
    {

    }

    @Test
    public void testIgnit()
    {

        Ignite ignite = Ignition.start("ignite-config/example-cache.xml");
        IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");
        // Store keys in cache (values will end up on different cache nodes).
        for (int i = 0; i < 10; i++)
            cache.put(i, Integer.toString(i));
        for (int i = 0; i < 10; i++)
            System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');

    }

}
