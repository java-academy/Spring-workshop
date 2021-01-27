package com.epam.javaacademy.jacekhorabik.spring_workshop.ships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ships")

public class ShipsController {

    private final ShipService shipService;

    @Autowired
    public ShipsController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("")
    public Set<Ship> getShips() {
        return shipService.getShips();
    }

    @PostMapping("/{shipName}")
    public ResponseEntity<?> addShip(@PathVariable String shipName) {
        try {
            Ship ship = shipService.addShip(shipName);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Location", "/ships/" + ship.getId())
                    .body(ship);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{shipName}")
    public ResponseEntity<String> removeShip(@PathVariable String shipName) {
        try {
            shipService.removeShip(shipName);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
