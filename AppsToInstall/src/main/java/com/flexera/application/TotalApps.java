package com.flexera.application;

import com.flexera.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Takes user input CSV file and passes it to the class where business logic is performed
 */
public class TotalApps {

    public static void main(String[] args) {
        String fileName = args[0];
        Integer totalAppcount=null;
        Map<Integer, User> userData = new HashMap<>(); //Holds user specific Unique data

        ProcessInputData processInputData = new ProcessInputData();
        Compute compute = new Compute();
        userData = processInputData.processCSV(fileName);
        totalAppcount = compute.workOnLapDeskCount(userData);

        System.out.println("Number of copies of application required : " + totalAppcount);
    }

}
