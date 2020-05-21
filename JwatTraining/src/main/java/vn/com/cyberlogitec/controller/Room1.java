package vn.com.cyberlogitec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


public class Room1 {
    private IAnimal animal;
    private String name = "Room1";

    @Autowired
    public Room1() {
        animal = new Bird();
    }

    public Room1(IAnimal animal){
        this.animal = animal;
    }

    public IAnimal getAnimal() {
        return animal;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Room: " + this.getName() + " Animal:" + this.getAnimal().getName();
    }
}
