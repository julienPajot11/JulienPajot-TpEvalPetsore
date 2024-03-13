package petstore.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "fish")
public class Fish extends Animal{
    @Enumerated(EnumType.STRING)
    @Column(name = "FISHLIVENV")
    private Fish.FishLivEnv fishLivEnv;

    public Fish() {
    }

    public Fish(LocalDateTime birth, String couleur, FishLivEnv fishLivEnv) {
        super(birth, couleur);
        this.fishLivEnv = fishLivEnv;
    }

    public enum FishLivEnv {
        FRESH_WATER,
        SEA_WATER
    }

    @Override
    public String toString() {
        return "Fish{" +

                "fishLivEnv=" + fishLivEnv +
                '}';
    }
}
