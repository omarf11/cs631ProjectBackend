package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.Employee;
import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.NurseRepository;
import com.nwaHospitalApi.nwaHospitalApi.Views.NurseView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired 
    private EmployeeService employeeService;

    public List<NurseView> getAllNurses() {
        List<nurse> nurses = nurseRepository.findAll();

        return nurses.stream().map(nurse -> 
        NurseView.builder()
        .employee_id(nurse.getEmployeeId())
        .id(nurse.getId())
        .shift(nurse.getShift())
        .shiftDate(nurse.getShift_date())
        .employeeInfo(employeeService.getEmployeeById(nurse.getEmployeeId()).get())
        .build()).collect(Collectors.toList()); 
    }

    public Optional<nurse> getNurseById(Integer id) {
        return nurseRepository.findById(id);
    }
   public NurseView getNurseByEmployee_Id(Integer employee_id) {
        if (nurseRepository.existsByemployeeId(employee_id)) {
            Optional<nurse> test = nurseRepository.findByemployeeId(employee_id);
            Optional <Employee> employeeInfo  = employeeService.getEmployeeById(test.get().getEmployeeId());

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
