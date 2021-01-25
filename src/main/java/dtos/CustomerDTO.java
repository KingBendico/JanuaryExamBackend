
package dtos;

import entities.Booking;
import entities.Creditcard;
import entities.Customer;
import java.util.List;


/**
 *
 * @author Bendico
 */

public class CustomerDTO {
    
    private String name;
    private String username;
    private String password;
    private String phone;
    
    private List<Booking> bookingList;
    private List<Creditcard> creditcardList;

    public CustomerDTO(Customer customer) {
        this.name = customer.getName();
        this.username = customer.getUsername();
        this.password = customer.getPassword();
        this.phone = customer.getPhone();
        this.bookingList = customer.getBookingList();
        this.creditcardList = customer.getCreditcardList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public List<Creditcard> getCreditcardList() {
        return creditcardList;
    }

    public void setCreditcardList(List<Creditcard> creditcardList) {
        this.creditcardList = creditcardList;
    }
    
    
    
    
}
