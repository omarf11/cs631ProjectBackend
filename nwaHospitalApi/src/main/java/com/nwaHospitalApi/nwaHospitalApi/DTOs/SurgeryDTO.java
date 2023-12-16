package com.nwaHospitalApi.nwaHospitalApi.DTOs;

import java.util.List;

import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse;
import com.nwaHospitalApi.nwaHospitalApi.Views.NurseView;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurgeryDTO {
    
    private Integer surgeryId;
    private String patientName;
    private String surgeryType;
    private Integer surgeryTypeId;
    private String date;
    private Integer surgeonId;
    private List<NurseView> nurses;
}
