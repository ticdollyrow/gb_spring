package ru.lesson7.lesson7.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "title")
    String  title;
    @Column(name = "price")
    Float cost;

    public Product(Long id, String title, Float cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

}

