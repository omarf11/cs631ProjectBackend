package com.nwaHospitalApi.nwaHospitalApi.DTOs;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SurgeryDTO {
    
    private Integer surgeryId;
    private String patientName;
    private String surgeryType;
    private String date;
    private String surgeonName;
    private List<String> nurses;
}
