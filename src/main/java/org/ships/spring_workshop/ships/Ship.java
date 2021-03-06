package org.ships.spring_workshop.ships;

import lombok.Value;

@Value
public class Ship {
    int id;
    String name;

    boolean hasTheSameName(String name) {
        return this.name.equals(name);
    }
}
