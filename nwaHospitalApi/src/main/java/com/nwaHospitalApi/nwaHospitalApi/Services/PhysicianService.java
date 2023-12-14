package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.Employee;
import com.nwaHospitalApi.nwaHospitalApi.Entities.physician;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.PhysicianRepository;
import com.nwaHospitalApi.nwaHospitalApi.Views.PhysicianView;

import java.util.List;
import java.util.Optional;

@Service
public class PhysicianService {

    @Autowired
    private PhysicianRepository physicianRepository;
    @Autowired 
    private EmployeeService employeeService;

    public List<physician> getAllPhysicians() {
        return physicianRepository.findAll();
    }

    public PhysicianView getPhysicianByEmployeeId(Integer employeeId) {
        if (physicianRepository.existsByemployeeId(employeeId)) { 
        Optional<physician> p = physicianRepository.findByemployeeId(employeeId);

        Optional <Employee> employeeInfo  = employeeService.getEmployeeById(p.get().getEmployeeId());

        return PhysicianView.builder()
        .employeeInfo(employeeInfo.get())
        .employee_id(employeeId)
        .id(p.get().getId())
        .specialty(p.get().getSpecialty())
        .type(p.get().getType())
        .build();
    
    }else {
            throw new RuntimeException("Nurse with employeeID " + employeeId + " not found");
        }

        
    }

    public physician createPhysician(physician physician) {
        return physicianRepository.save(physician);
    }

    public physician updatePhysician(Integer id, physician updatedPhysician) {
        if (physicianRepository.existsById(id)) {
            updatedPhysician.setId(id);
            return physicianRepository.save(updatedPhysician);
        } else {
            throw new RuntimeException("Physician with ID " + id + " not found");
        }
    }

    public void deletePhysician(Integer id) {
        if (physicianRepository.existsById(id)) {
            physicianRepository.deleteById(id);
        } else {
            throw new RuntimeException("Physician with ID " + id + " not found");
        }
    }
}

