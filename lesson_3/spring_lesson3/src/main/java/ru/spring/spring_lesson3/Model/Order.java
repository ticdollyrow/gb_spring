package ru.spring.spring_lesson3.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @Column(name = "info")
    private String dop_info;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders_history",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "buyer_id")
    )
    private List<Buyer> buyers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders_history",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Order(){

    }
    public Order(Long id, String dop_info) {
        this.id = id;
        this.dop_info = dop_info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDop_info() {
        return dop_info;
    }

    public void setDop_info(String dop_info) {
        this.dop_info = dop_info;
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
