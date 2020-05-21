package vn.com.cyberlogitec.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class Room3 {

    private IAnimal animal;
    private String name = "Room3";

    public Room3() {
        this.animal = new Cat();
    }

    public Room3(IAnimal animal) {
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
