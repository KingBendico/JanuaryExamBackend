/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Customer;
import entities.Creditcard;
import java.util.Date;


/**
 *
 * @author Bendico
 */


public class CreditcardDTO {
    
    private String type;
    private Integer cardNumber;
    private String expirationDate;
    private Date nameOnCard;
    private Customer customerid;

    public CreditcardDTO(Creditcard creditcard) {
        this.type = creditcard.getType();
        this.cardNumber = creditcard.getCardNumber();
        this.expirationDate = creditcard.getExpirationDate();
        this.nameOnCard = creditcard.getNameOnCard();
        this.customerid = creditcard.getCustomerid();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(Date nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }
    
    
    
    
    
    
}
