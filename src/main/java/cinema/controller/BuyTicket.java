package cinema.controller;

import cinema.businesslayer.Seat;

import java.util.UUID;


public class BuyTicket {
    private UUID token;
    private Seat ticket;

    public BuyTicket(Seat seat) {
        this.token = seat.getToken();
        this.ticket = seat;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }
}

