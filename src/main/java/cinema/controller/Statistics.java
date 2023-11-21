package cinema.controller;

public class Statistics {
    private long current_income;
    private long number_of_available_seats;
    private long number_of_purchased_tickets;

    public Statistics(long current_income, long number_of_available_seats, long number_of_purchased_tickets) {
        this.current_income = current_income;
        this.number_of_available_seats = number_of_available_seats;
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }

    public long getCurrent_income() {
        return current_income;
    }

    public void setCurrent_income(long current_income) {
        this.current_income = current_income;
    }

    public long getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public void setNumber_of_available_seats(long number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public long getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }

    public void setNumber_of_purchased_tickets(long number_of_purchased_tickets) {
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }
}