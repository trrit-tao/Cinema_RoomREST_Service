package cinema.businesslayer;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class Room {

    @JsonProperty("total_rows")
    private int totalRows = 9;
    @JsonProperty("total_columns")
    private int totalColumns = 9;
    @JsonProperty("available_seats")
    private List<Seat> seatList = new ArrayList<>();

    public Room() {
        createList();
    }

    public void createList(){
        int price = 10;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i >4){
                    price=8;
                }
                seatList.add(new Seat(i,j,price));
            }
        }
    }

    public Seat getSeat(int row, int column){
        return seatList.stream()
                .filter(a -> a.getRow()==row&&a.getColumn()==column)
                .findFirst()
                .orElseThrow();
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}