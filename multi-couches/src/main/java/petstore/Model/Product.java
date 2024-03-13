package petstore.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name = "CODE")
    private String code;
    @Column(name = "LABEL")
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProdType type;

    @Column(name = "PRICE")
    private double price;

    @ManyToMany(mappedBy="products")
    private Set<PetStore> petstores = new HashSet<>();

    public Product() {
    }

    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    public Set<PetStore> getPetstores() {
        return petstores;
    }

    public enum ProdType {
        FOOD,
        ACCESSORY,
        CLEANING
    }
}


