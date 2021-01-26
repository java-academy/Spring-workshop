package org.ships.spring_workshop.ships;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {

    @GetMapping
    String getWelcomeMessage() {
        return "Welcome to ships backend";
    }
}
