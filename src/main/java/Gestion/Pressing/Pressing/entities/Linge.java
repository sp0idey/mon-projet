package Gestion.Pressing.Pressing.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "linge")
public class Linge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLinge;

    @Column(nullable = false)
    private Double poidsLinge;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private Double prixUnitaire;

    // Getters and Setters
    public Long getIdLinge() {
        return idLinge;
    }

    public void setIdLinge(Long idLinge) {
        this.idLinge = idLinge;
    }

    public Double getPoidsLinge() {
        return poidsLinge;
    }

    public void setPoidsLinge(Double poidsLinge) {
        this.poidsLinge = poidsLinge;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
