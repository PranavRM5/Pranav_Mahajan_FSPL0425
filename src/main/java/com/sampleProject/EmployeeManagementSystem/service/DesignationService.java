package com.sampleProject.EmployeeManagementSystem.service;

import com.sampleProject.EmployeeManagementSystem.dto.DesignationDTO;
import com.sampleProject.EmployeeManagementSystem.entity.Designation;
import com.sampleProject.EmployeeManagementSystem.entity.Employee;
import com.sampleProject.EmployeeManagementSystem.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

    public Designation designationData(DesignationDTO designationDTO){
        Designation designation = new Designation();

        //Map DTO values to Entity
//        designation.setDesignationId(0L);
        designation.setDesignationName(designationDTO.getDesignationName());
        designation.setActive(true); // Assuming all new employees are active by default
        designation.setCreateBy(designationDTO.getCreateBy());
        designation.setUpdateBy(designationDTO.getUpdateBy());
        designation.setCreateDate(LocalDateTime.now());
        designation.setUpdatedDate(LocalDateTime.now());

        return designationRepository.save(designation);
    }

    public List<Designation> getAllDesignation() {
        List<Designation> list = designationRepository.findAll();
        return list;
    }
}
