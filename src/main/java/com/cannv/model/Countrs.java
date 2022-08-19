package com.cannv.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "countrs")
@Getter
@Setter
public class Countrs {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private  String code;
    @Column(name = "name")
    private  String name;
    @Column(name = "continent")
    private  String continent;
    @Column(name = "date_create")
    private String dateCreate;
    @Column(name = "language")
    private  String language;
    @Column(name = "area")
    private  String area;

    @Override
    public String toString() {
        return "Countrs{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                ", language='" + language + '\'' +
                ", area='" + area + '\'' +
                ", population=" + population +
                '}';
    }

    @Column(name = "population")
    private  Integer population;
}
