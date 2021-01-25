
package dtos;

import entities.Booking;
import entities.Customer;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Bendico
 */

public class CustomersDTO {
    
        List<CustomerDTO> all = new ArrayList();
    
    public CustomersDTO(List<Customer> customerEntities) {
        customerEntities.forEach((c) -> {
        all.add(new CustomerDTO(c));
         });
    }
  
}
