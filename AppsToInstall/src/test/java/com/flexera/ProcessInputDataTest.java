package com.flexera;
import static org.junit.Assert.assertEquals;

import com.flexera.application.Compute;
import com.flexera.application.ProcessInputData;
import com.flexera.model.User;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * UNIT testing of application and each method
 *
 */
public class ProcessInputDataTest
{

    @Test
    public void testTotalAppsCount_TestSet1(){

        String fileName=getClass().getResource("../../sample-test1.csv").getPath();
        Map<Integer, User> userData = new HashMap<>();

        ProcessInputData processInputData = new ProcessInputData();
        Compute compute = new Compute();
        userData = processInputData.processCSV(fileName);
        int totalAppcount = compute.workOnLapDeskCount(userData);
        assertEquals(1, totalAppcount);

        System.out.println("Number of copies of application required : " + totalAppcount);
    }

    @Test
    public void testTotalAppsCount_TestSet2(){


        String fileName=getClass().getResource("../../sample-test2.csv").getPath();
        Map<Integer, User> userData = new HashMap<>();

        ProcessInputData processInputData = new ProcessInputData();
        Compute compute = new Compute();
        userData = processInputData.processCSV(fileName);
        int totalAppcount = compute.workOnLapDeskCount(userData);
        assertEquals(3, totalAppcount);

        System.out.println("Number of copies of application required : " + totalAppcount);
    }

    @Test
    public void testTotalAppsCount_TestSet3(){

        String fileName=getClass().getResource("../../sample-test3.csv").getPath();
        Map<Integer, User> userData = new HashMap<>();

        ProcessInputData processInputData = new ProcessInputData();
        Compute compute = new Compute();
        userData = processInputData.processCSV(fileName);
        int totalAppcount = compute.workOnLapDeskCount(userData);
        assertEquals(2, totalAppcount);

        System.out.println("Number of copies of application required : " + totalAppcount);
    }

    /**
     * To test sample-small.csv
     */
    @Test
    public void testTotalAppsCount_SampleSmall(){

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String fileName=getClass().getResource("../../sample-small.csv").getPath();
        Map<Integer, User> userData = new HashMap<>();

        ProcessInputData processInputData = new ProcessInputData();
        Compute compute = new Compute();
        userData = processInputData.processCSV(fileName);
        int totalAppcount = compute.workOnLapDeskCount(userData);
        assertEquals(110069, totalAppcount);

        System.out.println("Number of copies of application required : " + totalAppcount);

        stopWatch.stop();
        System.out.println("Time (Milli secs) Taken for sample-small.csv: " + stopWatch.getTime());
    }

    /**
     * To test sample-large.csv file
     * commented this test case as intellij is getting hanged sometimes with huge data
     * When the jar file executed by command line, no issues as long as sufficient heap memory
     * (-Xmx5120m) is provided
     */
    @Test
    public void testTotalAppsCount_SampleLarge(){

/*        String fileName=getClass().getResource("../../sample-large.csv").getPath();
        Map<Integer, User> userData = new HashMap<>();

        ProcessInputData processInputData = new ProcessInputData();
        Compute compute = new Compute();
        userData = processInputData.processCSV(fileName);
        int totalAppcount = compute.workOnLapDeskCount(userData);
        assertEquals(10091137, totalAppcount);

        System.out.println("Number of copies of application required : " + totalAppcount);*/
    }

    @Test
    public void test_Method_ProcessCSV_Set1()
    {
        String fileName=getClass().getResource("../../sample-test2.csv").getPath();
        Map<Integer, User> userData = new HashMap<>();

        ProcessInputData processInputData = new ProcessInputData();
        Compute compute = new Compute();
        userData = processInputData.processCSV(fileName);

        assertEquals(2,userData.size());

    }

    @Test
    public void test_Method_ProcessCSV_Set2()
    {
        String fileName=getClass().getResource("../../sample-test3.csv").getPath();
        Map<Integer, User> userData = new HashMap<>();

        ProcessInputData processInputData = new ProcessInputData();
        Compute compute = new Compute();
        userData = processInputData.processCSV(fileName);

        assertEquals(2,userData.size());
    }

    @Test
    public void test_Method_ProcessCSV_Set3()
    {
        String fileName=getClass().getResource("../../sample-test1.csv").getPath();
        Map<Integer, User> userData = new HashMap<>();

        ProcessInputData processInputData = new ProcessInputData();
        Compute compute = new Compute();
        userData = processInputData.processCSV(fileName);

        assertEquals(1,userData.size());
    }

    @Test
    public void test_Method_totalAppsCount_Set1()
    {
        Compute compute = new Compute();
        Integer count =  compute.totalAppsCount(0,0,1,null);
        assertEquals(1,count.intValue());
    }

    @Test
    public void test_Method_totalAppsCount_Set2()
    {
        Compute compute = new Compute();
        Integer count =  compute.totalAppsCount(0,2,2,null);
        assertEquals(2,count.intValue());
    }
}
