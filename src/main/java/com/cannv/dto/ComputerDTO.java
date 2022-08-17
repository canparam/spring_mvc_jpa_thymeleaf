package com.cannv.dto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ComputerDTO {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "ComputerDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
