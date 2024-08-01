package Gestion.Pressing.Pressing.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "comptabilite")
public class Comptabilite {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompta;

    @Column(nullable = false)
    private Date datePaiement;

    @Column(nullable = false)
    private Double montantPaye;

    @Column(nullable = false)
    private String etat;

}
