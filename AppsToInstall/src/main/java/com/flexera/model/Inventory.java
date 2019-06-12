package com.flexera.model;

import lombok.*;

/**
 * To hold data from CSV
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Inventory {
    private int computerId;
    private int userID;
    private int applicationId;
    private String computerType;
    private String comment;
}