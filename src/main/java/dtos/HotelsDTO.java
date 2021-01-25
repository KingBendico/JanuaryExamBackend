/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Hotel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bendico
 */
public class HotelsDTO {
    
        List<HotelDTO> all = new ArrayList();
    
    public HotelsDTO(List<Hotel> hotelEntities) {
        hotelEntities.forEach((h) -> {
        all.add(new HotelDTO(h));
         });
    }
    
}
