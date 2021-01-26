package org.ships.spring_workshop.ships;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ShipService {
    private static int SHIP_ID_THRESHOLD = 0;

    @Getter
    private final List<Ship> shipList = new LinkedList<>();

    Ship addNewShip(String shipName) throws ShipAlreadyAddedException {
        if (shipList
                .stream().noneMatch(ship -> ship.hasTheSameName(shipName))) {
            Ship shipToAdd = new Ship(SHIP_ID_THRESHOLD++, shipName);
            shipList.add(shipToAdd);
            return shipToAdd;
        } else {
            throw new ShipAlreadyAddedException("There is a ship with this name");
        }

    }

    Ship removeShipFromList(String shipName) {
        Ship shipToRemove = shipList.stream()
                .filter(ship -> ship.hasTheSameName(shipName))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("There is no ship with such a name"));
        shipList.remove(shipToRemove);
        return shipToRemove;
    }

}
