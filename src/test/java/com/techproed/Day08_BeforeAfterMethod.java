package com.techproed;

import org.junit.*;

public class Day08_BeforeAfterMethod {
    @BeforeClass
    public static void setUp(){
        System.out.println("setUp calisti..");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("tearDown calisti..");
    }
    @Before
    public void beforeMethod(){
        System.out.println("beforeMethod calisti..");
    }
    @After
    public void afterMethod(){
        System.out.println("afterMethod calisti..");
    }
    @Test
    public void test1(){
        System.out.println("test1 calisti..");
    }
    @Test
    public void test2(){
        System.out.println("test2 calisti..");
    }

}
