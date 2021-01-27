package com.epam.javaacademy.jacekhorabik.spring_workshop.ships;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class ShipService {
    private static int id;
    @Getter
    private Set<Ship> ships = new HashSet<>();

    void addShip(String shipName) {
        ships.stream()
                .filter(ship -> ship.getName().equals(shipName))
                .findAny()
                .ifPresent(ship -> {
                    throw new IllegalArgumentException("Statek o danej nazwie juz istnieje!!");
                });
        id++;
        Ship ship = new Ship(id, shipName);
        ships.add(ship);
    }

    void removeShip(String shipName) {
        Ship ship = ships.stream()
                .filter(s -> s.getName().equals(shipName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Statek o danej nazwie nie istnieje!!"));
        ships.remove(ship);
    }
}
