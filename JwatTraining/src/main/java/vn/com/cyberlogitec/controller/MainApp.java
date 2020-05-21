package vn.com.cyberlogitec.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class MainApp {
    
    @Autowired
    Room1 room1;

    @Autowired
    Room2 room2;

    @Autowired
    Room3 room3;

    public static void main(String[] args) {
        System.out.println(room1.toString());
    }
}
