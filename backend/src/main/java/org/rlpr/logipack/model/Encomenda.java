package org.rlpr.logipack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_encomenda")
public class Encomenda {
    @Id
    @GeneratedValue
    private int id;
    private EncomendaEstado estado;
    private String emissor;
    private String destinatario;
    private int destinatarioId;
    @OneToOne
    private Localizacao localizacao;
    private Double peso;
    private int transportador;
    private String timestamp;
    private boolean confirmacao;
    private int cliente;
}
