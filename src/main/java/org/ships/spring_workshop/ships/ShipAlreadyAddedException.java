package org.ships.spring_workshop.ships;

class ShipAlreadyAddedException extends Exception {
    public ShipAlreadyAddedException(String s) {
        super(s);
    }
}
