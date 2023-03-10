package org.rlpr.logipack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_administrador")
public class Administrador {

    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String password_hash;
}
