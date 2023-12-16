package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.DTOs.SurgeryDTO;
import com.nwaHospitalApi.nwaHospitalApi.Entities.CreateSurgeryRequest;
import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse;
import com.nwaHospitalApi.nwaHospitalApi.Entities.surgery;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.SurgeryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SurgeryService {

    @Autowired
    private SurgeryRepository surgeryRepository;

    @Autowired
    private NurseService nurseService;

    @Autowired
    private PatientService patientService;

    @Autowired 
    private SurgeryTypeService surgeryTypeService;


    public List<surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    public Optional<surgery> getSurgeryById(Integer id) {
        return surgeryRepository.findById(id);
    }

    public surgery createSurgery(CreateSurgeryRequest surgeryRequest) {

        surgery surg = surgery.builder()
        .date(surgeryRequest.getDate())
        .patient_id(surgeryRequest.getPatientId())
        .surgeon_id(surgeryRequest.getSurgeonId())
        .surgery_type_id(surgeryRequest.getSurgeryTypeId())
        .theatre(surgeryRequest.getTheatre())
        .build();

        nurse n1 = nurseService.getNurseById(surgeryRequest.getNurseId1()).get();
        nurse n2 = nurseService.getNurseById(surgeryRequest.getNurseId2()).get();

        surgery savedSurg = surgeryRepository.save(surg);

        n1.setSurgeryId(savedSurg.getId());
        n2.setSurgeryId(savedSurg.getId());

        nurseService.updateNurse(n1.getId(), n1);
        nurseService.updateNurse(n2.getId(), n2);

System.out.println("SURGERY REQUEST: date  " + surgeryRequest.getDate());
System.out.println("SURGERY REQUEST:  patientId " + surgeryRequest.getPatientId());

System.out.println("SURGERY REQUEST:  surgeonId  " + surgeryRequest.getSurgeonId());
System.out.println("SURGERY REQUEST:  surgeryType  " + surgeryRequest.getSurgeryTypeId());

        return savedSurg;
    }

    public surgery updateSurgery(Integer id, surgery updatedSurgery) {
        if (surgeryRepository.existsById(id)) {
            updatedSurgery.setId(id);
            return surgeryRepository.save(updatedSurgery);
        } else {
            throw new RuntimeException("Surgery with ID " + id + " not found");
        }
    }

    public void deleteSurgery(Integer id) {
        if (surgeryRepository.existsById(id)) {
            surgeryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Surgery with ID " + id + " not found");
        }
    }

    public List<SurgeryDTO> getSurgerySchedule() {
        List<surgery> surgeries = surgeryRepository.findAll();

        List<SurgeryDTO> dto  = surgeries.stream().map(s -> 
        SurgeryDTO.builder()
        .surgeryId(s.getId())
        .patientName(patientService.getPatientById(s.getPatient_id()).get().getName())
        .date(s.getDate())
        .surgeonName(s.getSurgeon_id().toString())
        .surgeryType(surgeryTypeService.getSurgeryTypeById(s.getSurgery_type_id()).get().getType())
        .nurses(List.of("test1"))
        .build()
        ).collect(Collectors.toList()) ;
        return dto;
    }
}

