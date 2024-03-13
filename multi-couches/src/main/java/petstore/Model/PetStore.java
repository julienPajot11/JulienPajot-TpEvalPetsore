package petstore.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="petstore")
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    @Column(name="NAME")
    private String name;

    @Column(name="MANAGERNAME")
    private String managerName;
    @OneToOne
    private Address addresse;

    @ManyToMany
    @JoinTable(name="PETSTORE_PROD",
            joinColumns= @JoinColumn(name="ID_PETSTORE", referencedColumnName=
                    "ID"),
            inverseJoinColumns= @JoinColumn(name="ID_PROD", referencedColumnName="ID")
    )
    private Set<Product> products = new HashSet<>();

    @OneToMany(mappedBy="petStore")
    private Set<Animal> animals = new HashSet<>();

    public PetStore() {
    }

    public PetStore(String name, String managerName, Address addresse) {
        this.name = name;
        this.managerName = managerName;
        this.addresse = addresse;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void addProduct(Product produit){
        products.add(produit);
        produit.getPetstores().add(this);
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", addresse=" + addresse +
                '}';
    }
}
