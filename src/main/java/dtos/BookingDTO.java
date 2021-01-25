
package dtos;

import entities.Customer;
import entities.Booking;
import entities.Hotel;
import java.util.Date;


/**
 *
 * @author Bendico
 */
public class BookingDTO {
    

    private Date startDate;
    private Integer numberOfNights;
    private Double pricePrNight;
    private Customer customerid;
    private Hotel hotelid;

    public BookingDTO(Booking booking) {
        this.startDate = booking.getStartDate();
        this.numberOfNights = booking.getNumberOfNights();
        this.pricePrNight = booking.getPricePrNight();
        this.customerid = booking.getCustomerid();
        this.hotelid = booking.getHotelid();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public Double getPricePrNight() {
        return pricePrNight;
    }

    public void setPricePrNight(Double pricePrNight) {
        this.pricePrNight = pricePrNight;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public Hotel getHotelid() {
        return hotelid;
    }

    public void setHotelid(Hotel hotelid) {
        this.hotelid = hotelid;
    }

    
    
    
    
}
