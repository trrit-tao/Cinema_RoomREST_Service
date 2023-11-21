package cinema.businesslayer;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Seat {
    @JsonIgnore
    private final UUID token = UUID.randomUUID();
    private int row;
    private int column;
    private int price;
    @JsonIgnore
    public boolean available = true;

    public Seat() {
    }

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public UUID getToken() {
        return token;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}