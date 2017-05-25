package com.aobin;

import com.google.common.collect.HashBasedTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 敖斌 on 2017/5/16.
 */

// Guava在线文档 http://tool.oschina.net/apidocs/apidoc?api=guava
public class GuavaTest
{

    @Before
    public void before()
    {

    }

    @After
    public void after()
    {

    }

    @Test
    public void testTable()
    {
        HashBasedTable<Integer, String, List<String>> table = HashBasedTable.create();
        table.put(1, "names", Arrays.asList("aa", "bb"));
        table.put(3, "names", Arrays.asList("aaa", "bbb"));
        table.put(2, "huhu", Arrays.asList("cc", "dd"));
        //table.column()

    }

}
