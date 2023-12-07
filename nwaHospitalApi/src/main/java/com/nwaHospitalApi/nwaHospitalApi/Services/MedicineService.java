package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.medicine;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.MedicineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public List<medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Optional<medicine> getMedicineById(Integer id) {
        return medicineRepository.findById(id);
    }

    public medicine createMedicine(medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public medicine updateMedicine(Integer id, medicine updatedMedicine) {
        if (medicineRepository.existsById(id)) {
            updatedMedicine.setId(id);
            return medicineRepository.save(updatedMedicine);
        } else {
            throw new RuntimeException("Medicine with ID " + id + " not found");
        }
    }

    public void deleteMedicine(Integer id) {
        if (medicineRepository.existsById(id)) {
            medicineRepository.deleteById(id);
        } else {
            throw new RuntimeException("Medicine with ID " + id + " not found");
        }
    }
}

