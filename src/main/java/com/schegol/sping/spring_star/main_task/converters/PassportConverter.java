package com.schegol.sping.spring_star.main_task.converters;

import com.schegol.sping.spring_star.main_task.dto.PassportDTO;
import com.schegol.sping.spring_star.main_task.models.Passport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassportConverter {

    public PassportDTO entityToDTO(Passport passport){

        PassportDTO dto = new PassportDTO();
        dto.setSeries(passport.getSeries());
        dto.setNumber(passport.getNumber());
        dto.setDateOfIssue(passport.getDateOfIssue());
        return dto;
    }

    public List<PassportDTO> entityToDTO(List<Passport> passports){
        return passports.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public  Passport DTOtoEntity(PassportDTO dto){
        Passport p = new Passport();
        p.setSeries(dto.getSeries());
        p.setNumber(dto.getNumber());
        p.setDateOfIssue(dto.getDateOfIssue());
        return p;
    }

    public List<Passport> DTOToEntity(List<PassportDTO> dto){
        return dto.stream().map(x -> DTOtoEntity(x)).collect(Collectors.toList());
    }
}
