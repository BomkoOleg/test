package net.oleg.contactmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Pictures {

    @Column(name = "id", length = 4)
    private long id;
    @Column(name = "name", length = 20)
    private String name; 

}
