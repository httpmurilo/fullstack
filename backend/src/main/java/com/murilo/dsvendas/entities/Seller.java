package com.murilo.dsvendas.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Nome do atributo mapeado do outro lado
    @OneToMany(mappedBy = "seller")
    private List<Sale> sales = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seller(){
    }

    public Seller(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Sale> getSales() {
        return sales;
    }
}
