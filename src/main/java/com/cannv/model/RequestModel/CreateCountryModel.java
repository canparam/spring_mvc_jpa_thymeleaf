package com.cannv.model.RequestModel;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CreateCountryModel {
    @NotEmpty
    private  String code;
    @NotEmpty
    private  String name;
    @NotEmpty
    private  String continent;
    @NotEmpty
    private String dateCreate;
    @NotEmpty
    private  String language;
    @NotEmpty
    private  String area;
    @NotNull
    private  Integer population;
}
