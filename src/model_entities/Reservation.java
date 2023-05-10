package model_entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer room;
    private Date checkIn;
    private Date checkOut;

    public Reservation(Integer room, Date checkIn, Date checkOut) {
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoom() {
        return room;
    }
    public void setRoom(Integer room) {
        this.room = room;
    }
    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }


    public long duration(){
        long dif = checkOut.getTime() - checkIn.getTime()  ;
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Room " +
        room +
        ", Check-in: " +
        sdf.format(checkIn) +
        ", Check-out: " +
        sdf.format(checkOut) + 
        ", " + duration() +
        " Nights";
    }
}
