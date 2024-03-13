package petstore.Test;

import jakarta.persistence.*;
import petstore.Model.*;

import java.time.LocalDateTime;
import java.util.List;

public class TestPetStore {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        //Instanciation de tous les éléments
        Cat cat1 = new Cat(LocalDateTime.now(),"blanc","124");
        Cat cat2 = new Cat(LocalDateTime.now(),"gris","158");
        Cat cat3 = new Cat(LocalDateTime.now(),"bleu","175");

        Fish fish1 = new Fish(LocalDateTime.now(),"rouge", Fish.FishLivEnv.FRESH_WATER);
        Fish fish2 = new Fish(LocalDateTime.now(),"bleu", Fish.FishLivEnv.SEA_WATER);
        Fish fish3 = new Fish(LocalDateTime.now(),"rose", Fish.FishLivEnv.SEA_WATER);

        Address adresse1 = new Address("14","labas","1452","nantes");
        Address adresse2 = new Address("5","pasici","3205","la roche sur yon");
        Address adresse3 = new Address("13","labas","5898","les sables d'olonne");

        PetStore petStore1 = new PetStore("Les animaux de fou","Didier LEBLANC", adresse1);
        PetStore petStore2 = new PetStore("La ferme en folie","François LECHEF", adresse2);
        PetStore petStore3 = new PetStore("Les petits poissons","Galaad DOSANTOS", adresse3);

        Product produit1 = new Product("4598","Shampoing", Product.ProdType.CLEANING, 58.8);
        Product produit2 = new Product("3333","croquette", Product.ProdType.FOOD, 78.8);
        Product produit3 = new Product("7895","arbre a chat", Product.ProdType.ACCESSORY, 100.0);

        // ajout des animaux dans les petstore
        cat1.setPetStore(petStore1);
        cat2.setPetStore(petStore2);
        cat3.setPetStore(petStore3);

        fish1.setPetStore(petStore1);
        fish2.setPetStore(petStore2);
        fish3.setPetStore(petStore3);

        petStore1.addProduct(produit1);
        petStore1.addProduct(produit2);
        petStore1.addProduct(produit3);

        petStore2.addProduct(produit1);
        petStore2.addProduct(produit2);

        petStore3.addProduct(produit3);
        petStore3.addProduct(produit2);

        //Persist pour les ajoutés dans la base
        em.persist(cat1);
        em.persist(cat2);
        em.persist(cat3);

        em.persist(fish1);
        em.persist(fish2);
        em.persist(fish3);

        em.persist(adresse1);
        em.persist(adresse2);
        em.persist(adresse3);

        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);

        em.persist(produit1);
        em.persist(produit2);
        em.persist(produit3);



        et.commit();
        // marche
        int petstore = 1;
        PetStore getPetStore = em.find(PetStore.class, petstore);
        if (getPetStore != null){
            System.out.println("Animaux du petsore : " + getPetStore.getAnimals());
        }

        //pour le plaisir avec une Jquery changer le 1 pour avoir les autres
        TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a WHERE a.petStore.id= 1", Animal.class);
                List<Animal> animauxFromPetStore = query.getResultList();
        for(Animal animal : animauxFromPetStore){
            System.out.println(animal);
        }

        em.close();
        entityManagerFactory.close();
    }
}
