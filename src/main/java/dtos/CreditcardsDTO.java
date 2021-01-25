/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Creditcard;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bendico
 */
public class CreditcardsDTO {
    
    
        List<CreditcardDTO> all = new ArrayList();
    
    public CreditcardsDTO(List<Creditcard> creditcardEntities) {
        creditcardEntities.forEach((c) -> {
        all.add(new CreditcardDTO(c));
         });
    }
    
    
}
