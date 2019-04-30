/*
Project: Team Project Design
Purpose Details: Car Dealership Create the Java Classes
Course: IST 242
Author: Team 5 all members
Date Developed: 4/29/2019
Last Date Changed: 4/29/2019
Revision: Final
*/

package com.company;

import java.util.ArrayList;

public class Inventory {

    private ArrayList carList;
    private ArrayList partsList;

    //Methods

    public Inventory() {

        carList = new ArrayList<Cars>();
        partsList = new ArrayList<Parts>();
    }

    public void setCars(Cars _car) {
        carList.add(_car);
    }
    public Cars getCars(int _car) {
        return (Cars) carList.get(_car);
    }
    public void serParts(Parts _part) {
        partsList.add(_part);
    }
    public Parts getParts(int _part) {
        return (Parts) partsList.get(_part);
    }
}