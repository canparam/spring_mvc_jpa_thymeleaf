package com.cannv.service;

import com.cannv.dto.ComputerDTO;
import com.cannv.model.Computer;
import com.cannv.model.RequestModel.CreateComputerModel;
import com.cannv.repository.ComputerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;

    @Autowired
    private ModelMapper mapper;

    @Transactional(readOnly = true)
    public List<ComputerDTO> getAll(){
        List<ComputerDTO> dto = new ArrayList<>();
        for (Computer c : this.computerRepository.findAll()){
            dto.add(mapper.map(c,ComputerDTO.class));
        }
        return dto;
    }
    @Transactional
    public Computer create(CreateComputerModel model){
        Computer computer = new Computer();
        computer.setName(model.getName());
        computer.setProducer(model.getProducer());
        computer.setYear(model.getYear());
        this.computerRepository.save(computer);
        return computer;
    }
}
