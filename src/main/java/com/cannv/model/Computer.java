package com.cannv.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comp")
public class Computer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", dateC=" + dateC +
                ", year=" + year +
                ", configuration='" + configuration + '\'' +
                ", price=" + price +
                '}';
    }

    @Column(name = "name")
    private String name;

    @Column(name = "producer")
    private String producer;
    @Column(name = "date_c")
    private Date dateC;

    @Column(name = "year")
    private Integer year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getDateC() {
        return dateC;
    }

    public void setDateC(Date dateC) {
        this.dateC = dateC;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Column(name = "configuration")
    private String configuration;

    public Computer() {
    }



    @Column(name = "price")
    private Float price;
}
