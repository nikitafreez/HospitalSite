package com.example.Individual_Project.controllers;

import com.example.Individual_Project.Repo.Ambulance.AmbulanceCallRepository;
import com.example.Individual_Project.Repo.Ambulance.AmbulanceCarRepository;
import com.example.Individual_Project.Repo.Documents.PassportRepository;
import com.example.Individual_Project.Repo.Medicine.DiseaseRepository;
import com.example.Individual_Project.Repo.Medicine.TreatmentRepository;
import com.example.Individual_Project.Repo.People.PatientRepository;
import com.example.Individual_Project.Repo.People.WorkerRepository;
import com.example.Individual_Project.models.Ambulance.Ambulance_call;
import com.example.Individual_Project.models.Ambulance.Ambulance_car;
import com.example.Individual_Project.models.Documents.Passport;
import com.example.Individual_Project.models.Medicine.Disease;
import com.example.Individual_Project.models.Medicine.Treatment;
import com.example.Individual_Project.models.People.Patient;
import com.example.Individual_Project.models.People.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MedicineController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DiseaseRepository diseaseRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private PassportRepository passportRepository;

    @GetMapping("/disease")
    public String diseaseMain(Disease disease, Model model) {
        Iterable<Disease> diseases = diseaseRepository.findAll();
        model.addAttribute("diseases", diseases);
        return "/Medicine/disease-view";
    }

    @PostMapping("/disease/add")
    public String diseaseAdd(@Valid Disease disease,
                             BindingResult bindingResult,
                             @RequestParam String diseaseName,
                             @RequestParam String treatmentMethod) {
        if (bindingResult.hasErrors()) {
            return "/Medicine/disease-view";
        }
        Disease disease1 = new Disease(diseaseName, treatmentMethod);
        diseaseRepository.save(disease1);
        return "redirect:/disease";
    }

    @GetMapping("/disease/{id}/remove")
    public String diseaseDelete(@PathVariable(value = "id") Long id,
                                Model model) {
        Disease disease = diseaseRepository.findById(id).orElseThrow();
        diseaseRepository.delete(disease);
        return "redirect:/disease";
    }


    @GetMapping("/treatment")
    public String treatmentMain(Treatment treatment, Model model) {
        Iterable<Disease> diseases = diseaseRepository.findAll();
        Iterable<Patient> patients = patientRepository.findAll();
        Iterable<Treatment> treatments = treatmentRepository.findAll();
        model.addAttribute("diseases", diseases);
        model.addAttribute("patients", patients);
        model.addAttribute("treatments", treatments);
        return "/Medicine/treatment-view";
    }

    @PostMapping("/treatment/add")
    public String treatmentAdd(@Valid Treatment treatment,
                               BindingResult bindingResult,
                               @RequestParam String diseaseName,
                               @RequestParam String passport,
                               @RequestParam String treatmentDate) {
        if (bindingResult.hasErrors()) {
            return "/Medicine/treatment-view";
        }
        Patient patient = patientRepository.findByPassport(passportRepository.findByPassSeriaAndPassNum(passport.substring(0, 4), passport.substring(5, 11)));
        Disease disease = diseaseRepository.findByDiseaseName(diseaseName);
        Treatment treatment1 = new Treatment(treatmentDate, disease, patient);
        treatmentRepository.save(treatment1);
        return "redirect:/treatment";
    }

    @GetMapping("/treatment/{id}/remove")
    public String treatmentDelete(@PathVariable(value = "id") Long id,
                                  Model model) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow();
        treatmentRepository.delete(treatment);
        return "redirect:/treatment";
    }
}
