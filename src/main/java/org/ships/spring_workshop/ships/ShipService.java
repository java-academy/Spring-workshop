package org.ships.spring_workshop.ships;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ShipService {
    @Getter
    private List<Ship> shipList = new LinkedList<>();

    void addNewShip(Ship ship) {
        shipList.add(ship);
    }

    void removeShipFromList(Ship ship) {
        if (shipList.contains(ship)) {
            shipList.remove(ship);
        } else {
            throw new NoSuchElementException("There is no such a ship in ShipService");
        }
    }
}
