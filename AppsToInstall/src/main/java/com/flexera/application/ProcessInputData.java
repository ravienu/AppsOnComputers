package com.flexera.application;

import com.flexera.model.ComputerType;
import com.flexera.model.Inventory;
import com.flexera.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class mainly handles the processing of CSV data as per the business logic
 */
public class ProcessInputData {

    /**
     * @param fileName
     * @return totalAppsReq
     * This methods takes csv fileName as input
     */
    public Map<Integer, User> processCSV(String fileName) {

        int totalAppsReq = 0;
        List<Inventory> inventoryList = new ArrayList<Inventory>();
        Map<Integer, User> users = new HashMap<>(); //Holds user specific Unique data
        try {

            File file = new File(fileName);
            InputStream inputFS = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

            inventoryList = br.lines().skip(1).map(csvToObject).collect(Collectors.toList());

            inventoryList.stream().forEach(inv -> {
                User user;

                if (users.keySet().contains(inv.getUserID())) {
                    user = users.get(inv.getUserID());
                } else {
                    user = new User();
                }

                if (user.getApplicationIds().contains(inv.getApplicationId())
                        && user.getComputerIds().contains(inv.getComputerId())) {
                    //Duplicate entries
                } else {
                    user.setUserId(inv.getUserID());
                    user.getComputerIds().add(inv.getComputerId());
                    user.getApplicationIds().add(inv.getApplicationId());
                    user.getComputerTypes().add(inv.getComputerType());
                    if (inv.getComputerType().equalsIgnoreCase(ComputerType.DESKTOP.name())) {
                        user.setDesktopCount(user.getDesktopCount() + 1);
                    } else if (inv.getComputerType().equalsIgnoreCase(ComputerType.LAPTOP.name())) {
                       // user.setLaptopCount(user.getLaptopCount() + 1);
                        user.setLaptopCount(user.getLaptopCount()+1);
                    }
                    users.put(inv.getUserID(), user);
                }

            });

        } catch (Exception e) {
            System.out.println("Exception while reading CSV file  :: " + e.getStackTrace());
            e.printStackTrace();
        }
        return users;
    }

    /**
     * map csv to object
     */
    public Function<String, Inventory> csvToObject = (line)  -> {
        String[] p = line.split(",");

        Inventory item = new Inventory();
        item.setComputerId(Integer.parseInt(p[0]));
        item.setUserID(Integer.parseInt(p[1]));
        item.setApplicationId(Integer.parseInt(p[2]));
        item.setComputerType(p[3]);
        item.setComment(p[4]);
        return item;
    };


}