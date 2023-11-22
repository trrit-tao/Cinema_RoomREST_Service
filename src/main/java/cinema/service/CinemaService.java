package cinema.service;

import cinema.businesslayer.Room;
import cinema.businesslayer.Seat;
import cinema.controller.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CinemaService {
    private Room room;

    public CinemaService(Room room) {
        this.room = room;
    }


    public ResponseEntity<?> postReturn(TokenDTO tokenDTO) {
        Optional<Seat> seatOpt = room.getSeatList()
                .stream()
                .filter(a -> a.getToken().equals(tokenDTO.getToken()))
                .findFirst();

        if (seatOpt.isEmpty()||seatOpt.get().isAvailable()) {
            return new ResponseEntity<>(new ErrorResponse("Wrong token!"), HttpStatus.BAD_REQUEST);
        }
        Seat seat = seatOpt.get();
        seat.setAvailable(true);
        return new ResponseEntity<>(new RefundTicket(seat), HttpStatus.OK);
    }


    public ResponseEntity<?> postPurchase(ModelDTO modelDTO) {
        if (modelDTO.getRow() > 9
                || modelDTO.getColumn() > 9
                || modelDTO.getRow() < 1
                || modelDTO.getColumn() < 1
        ) {
            return new ResponseEntity<>(
                    new ErrorResponse("The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST
            );
        }
        BuyTicket element = new BuyTicket(room.getSeat(modelDTO.getRow(), modelDTO.getColumn()));
        if (!element.getTicket().isAvailable()) {
            return new ResponseEntity<>(
                    new ErrorResponse("The ticket has been already purchased!"), HttpStatus.BAD_REQUEST
            );
        }
        element.getTicket().setAvailable(false);
        return new ResponseEntity<>(element, HttpStatus.OK);
    }


    public ResponseEntity<?> getStats(){
        long income = room.getSeatList().stream().filter(a->!(a.isAvailable())).mapToLong(Seat::getPrice).sum();
        long availableSeats = room.getSeatList().stream().filter(Seat::isAvailable).count();
        long purchasedTickets = room.getSeatList().stream().filter(a->!(a.isAvailable())).count();
        return new ResponseEntity<>(new Statistics(income,availableSeats,purchasedTickets),HttpStatus.OK);
    }


    public Room getRoom() {
        return room;
    }


    public void setRoom(Room room) {
        this.room = room;
    }
}