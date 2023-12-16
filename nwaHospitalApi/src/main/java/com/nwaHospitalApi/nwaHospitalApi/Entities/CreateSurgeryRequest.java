package com.nwaHospitalApi.nwaHospitalApi.Entities;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateSurgeryRequest {

    private String date;

    private String theatre;

    private Integer surgeonId;

    private Integer patientId;

    private Integer surgeryTypeId;

    private Integer nurseId1;

    private Integer nurseId2;

}
