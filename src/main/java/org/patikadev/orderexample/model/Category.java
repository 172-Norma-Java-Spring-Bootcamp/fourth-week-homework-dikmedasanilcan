package org.patikadev.orderexample.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Category extends BaseModel {
    @OneToOne(cascade = CascadeType.PERSIST,orphanRemoval = true)
    private Category parent;
    @Column(unique = true,nullable = false)
    private String name;
}
