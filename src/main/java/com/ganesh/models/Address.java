package com.ganesh.models;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @created: 20/09/2021 - 11:43 AM
 * @author: Ganesh
 */

@Data
@AllArgsConstructor
public class Address {

    private String country;
    private String postCode;
    private String city;

}
