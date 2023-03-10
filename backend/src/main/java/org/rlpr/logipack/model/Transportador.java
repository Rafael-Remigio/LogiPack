package org.rlpr.logipack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_transportador")
public class Transportador {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String email;
    private String password_hash;
    private String telefone;
    private String matricula;
    private String timestamp;
    private TransportadorEstado estado;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Encomenda> encomendas;
}
