package petstore.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "cat")
public class Cat extends Animal{
    @Column(name = "CHIPID")
    private String chipId;

    public Cat() {
    }

    public Cat( LocalDateTime birth, String couleur, String chipId) {
        super(birth, couleur);
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "chipId='" + chipId + '\'' +
                '}';
    }
}
