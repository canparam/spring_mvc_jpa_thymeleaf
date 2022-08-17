package com.cannv.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Players")
@Getter
@Setter
public class Players {
    @Id
    @Column(name = "PlayerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;

    @Column(name = "PlayerName")
    private String playerName;

    @Column(name = "Gender")
    private Integer gender;
    @Column(name = "BirtDay")
    private Date birtday;
    @Column(name = "Address")
    private String address;
    @Column(name = "TeamName")
    private String teamName;
    @Column(name = "PositionPlay")
    private String positionPlay;

    @Column(name = "TransportCost")
    private Float transportCost;
}

