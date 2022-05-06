package org.patikadev.orderexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Orders")
public class Order extends BaseModel{
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Basket basket;

    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Date orderedDate;


}
