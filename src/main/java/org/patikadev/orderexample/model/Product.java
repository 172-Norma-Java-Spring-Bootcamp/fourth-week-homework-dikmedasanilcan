package org.patikadev.orderexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Product extends BaseExtendedModel {
    @NotBlank(message = "Product name can not be blank")
    @NotNull(message = "Product name can not be null")
    private String name;
    @Min(value = 0,message = "Product price can not be negative")
    private BigDecimal price;
    @Column(unique = true)
    private UUID barcode;
    private String image;
    @Min(value = 0,message = "Stock can not be negative")
    private Integer stock;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull(message = "Product Brand can not be null")
    private Brand brand;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull(message = "Product Category can not be null")
    private Category category;


}
