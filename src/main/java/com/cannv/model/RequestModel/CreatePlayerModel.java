package com.cannv.model.RequestModel;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.sql.Date;
@Getter
@Setter
public class CreatePlayerModel {

    @NotEmpty
    private String playerName;
    @NotNull
    private Integer gender;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date birtday;
    @NotEmpty
    private String address;
    @NotEmpty
    private String teamName;
    @NotEmpty
    private String positionPlay;
    @NotNull
    private Float transportCost;
}
