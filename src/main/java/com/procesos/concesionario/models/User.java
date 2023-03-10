package com.procesos.concesionario.models;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
@Data
@Entity

public class User {
    @Id
    private Long id;
    @Column(name = "first_name")
    private String fistname;
    @Column(name = "last_name")
    private String lastname;

    private String email;
    private String password;
    private String address;
    private LocalDate birtday;


}
