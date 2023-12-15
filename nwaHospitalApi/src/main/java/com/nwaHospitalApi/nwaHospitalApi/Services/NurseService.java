package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.DTOs.NurseEmployeeDTO;
import com.nwaHospitalApi.nwaHospitalApi.Entities.Employee;
import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.NurseRepository;
import com.nwaHospitalApi.nwaHospitalApi.Views.NurseView;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private EmployeeService employeeService;

    public List<NurseEmployeeDTO> getAllNursesEmployeeInfo() {

        List<NurseEmployeeDTO> nurses = nurseRepository.findAllNurseAndEmployees()
                .stream()
                .map(result -> NurseEmployeeDTO.builder()
                        .id((Integer) result[0])
                        .years((String) result[1])
                        .shift((String) result[2])
                        .shift_date((String) result[3])
                        .employeeId((Integer) result[4])
                        .surgery_type((Integer) result[5])
                        .surgery_skill((Integer) result[6])
                        .emp_id((Integer) result[7])
                        .ssn((Integer) result[8])
                        .address((String) result[9])
                        .salary((Integer) result[10])
                        .name((String) result[11])
                        .gender((String) result[12])
                        .phonenumber((Integer) result[13])
                        .type((String) result[14])
                        .build())
                .collect(Collectors.toList());
        return nurses;
    }

    public Optional<nurse> getNurseById(Integer id) {
        return nurseRepository.findById(id);
    }

    public NurseView getNurseByEmployee_Id(Integer employee_id) {
        if (nurseRepository.existsByemployeeId(employee_id)) {
            Optional<nurse> test = nurseRepository.findByemployeeId(employee_id);
            Optional<Employee> employeeInfo = employeeService.getEmployeeById(test.get().getEmployeeId());

            NurseView nurseView = NurseView.builder()
                    .employee_id(test.get().getEmployeeId())
                    .id(test.get().getId())
                    .employeeInfo(employeeInfo.get())
                    .shift(test.get().getShift())
                    .shiftDate(test.get().getShift_date())
                    .surgery_skill(test.get().getSurgery_skill())
                    .surgery_type(test.get().getSurgery_type())
                    .build();
            return nurseView;
        } else {
            throw new RuntimeException("Nurse with employeeID " + employee_id + " not found");
        }
    }

    public nurse createNurse(nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public nurse updateNurse(Integer id, nurse updatedNurse) {
        if (nurseRepository.existsById(id)) {
            updatedNurse.setId(id);
            return nurseRepository.save(updatedNurse);
        } else {
            throw new RuntimeException("Nurse with ID " + id + " not found");
        }
    }

    public void deleteNurse(Integer id) {
        if (nurseRepository.existsById(id)) {
            nurseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Nurse with ID " + id + " not found");
        }
    }
}
