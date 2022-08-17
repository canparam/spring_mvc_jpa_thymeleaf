package com.cannv.model.RequestModel;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateComputerModel {
    @NotEmpty(message = "User's name cannot be empty.")
    private String name;
    @NotEmpty
    private String producer;
    @NotNull
    private Integer year;
}
