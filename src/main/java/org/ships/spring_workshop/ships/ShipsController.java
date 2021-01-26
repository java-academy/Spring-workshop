package org.ships.spring_workshop.ships;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/ships", produces = "application/json")
@CrossOrigin("http://localhost:4200")
public class ShipsController {
    ShipService shipService;

    @Autowired
    ShipsController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    ResponseEntity<List<Ship>> getListOfShips() {
        return new ResponseEntity<>(shipService.getShipList(), HttpStatus.OK);
    }

    @PostMapping("/{shipName}")
    ResponseEntity<Ship> addShip(@PathVariable String shipName) {
        try {
            return new ResponseEntity<>(shipService.addNewShip(shipName), HttpStatus.CREATED);
        } catch (ShipAlreadyAddedException saae) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{shipName}")
    ResponseEntity<Ship> deleteShip(@PathVariable String shipName) {
        try {
            return new ResponseEntity<>(shipService.removeShipFromList(shipName), HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
