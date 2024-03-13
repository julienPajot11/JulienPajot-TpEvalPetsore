package petstore.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="BIRTH")
    private LocalDateTime birth;

    @Column(name = "COULEUR")
    private String couleur;

    @ManyToOne
    @JoinColumn(name="PETSTORE_ID")
    private PetStore petStore;

    public Animal() {
    }

    public Animal( LocalDateTime birth, String couleur) {
        this.birth = birth;
        this.couleur = couleur;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
        petStore.getAnimals().add(this);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
