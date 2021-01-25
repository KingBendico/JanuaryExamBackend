/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Booking;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bendico
 */
public class BookingsDTO {
    
    List<BookingDTO> all = new ArrayList();
    
    public BookingsDTO(List<Booking> bookingEntities) {
        bookingEntities.forEach((b) -> {
        all.add(new BookingDTO(b));
         });
    }
        
    
}
