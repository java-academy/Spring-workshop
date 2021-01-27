package com.epam.javaacademy.jacekhorabik.spring_workshop.ships;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShipService {
    private static int id;
    @Getter
    private Set<Ship> ships = new HashSet<>();

    Ship addShip(String shipName) {
        ships.stream()
                .filter(ship -> ship.getName().equals(shipName))
                .findAny()
                .ifPresent(ship -> {
                    throw new IllegalArgumentException("Statek o danej nazwie juz istnieje!!");
                });
        Ship ship = new Ship(id++, shipName);
        ships.add(ship);
        return ship;
    }

    void removeShip(String shipName) {
        Ship ship = ships.stream()
                .filter(s -> s.getName().equals(shipName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Statek o danej nazwie nie istnieje!!"));
        ships.remove(ship);
    }
}
