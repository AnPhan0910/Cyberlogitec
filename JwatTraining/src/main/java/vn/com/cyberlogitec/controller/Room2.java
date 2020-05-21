package vn.com.cyberlogitec.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class Room2 {

    private IAnimal animal;
    private String name = "Room2";

    public Room2() {
        this.animal = new Dog();
    }

    @Autowired
    public Room2(IAnimal animal){
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
