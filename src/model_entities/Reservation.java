package model_entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model_exceptions.DomainException;

public class Reservation {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer room;
    private Date checkIn;
    private Date checkOut;

    public Reservation(Integer room, Date checkIn, Date checkOut) throws DomainException{
        if(!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date!") ;
        }
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

    public String updateDates(Date checkIn, Date checkOut) throws DomainException{
        Date now = new Date();

        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("The dates must be in the future") ;
        }
        if(!checkOut.after(checkIn)){
            throw new DomainException("Error in reservation: Check-out date must be after check-in date!") ;
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
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
