package com.flexera.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * To store per user data
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int userId;
    private List<String> computerTypes;
    private Set<Integer> applicationIds;
    private Set<Integer> computerIds;
    private int laptopCount;
    private int desktopCount;

    public List<String> getComputerTypes() {
        if(computerTypes==null){
            computerTypes = new ArrayList<>();
        }
        return computerTypes;
    }

    public Set<Integer> getApplicationIds() {
        if(applicationIds==null){
            applicationIds = new HashSet<>();
        }
        return applicationIds;
    }

    public Set<Integer> getComputerIds() {
        if(computerIds==null){
            computerIds = new HashSet<>();
        }
        return computerIds;
    }
}