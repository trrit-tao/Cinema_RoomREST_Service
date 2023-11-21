package cinema.controller;

import cinema.service.CinemaService;
import cinema.businesslayer.Room;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
public class CinemaController {
    private final CinemaService service;


    public CinemaController(CinemaService service) {
        this.service = service;
    }

    @GetMapping("/seats")
    public Room getRoom() {
        return service.getRoom();
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> buyTicket(@RequestBody ModelDTO modelDTO) {
        return service.postPurchase(modelDTO);
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody TokenDTO tokenDTO) {
        return service.postReturn(tokenDTO);
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(@RequestParam(required = false) String password) {
        if (Objects.equals(password, "super_secret")) {
            return service.getStats();
        }
        return new ResponseEntity<>(
                new ErrorResponse("The password is wrong!"), HttpStatus.UNAUTHORIZED);
    }
}