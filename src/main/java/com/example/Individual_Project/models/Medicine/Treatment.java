package com.example.Individual_Project.models.Medicine;

import com.example.Individual_Project.models.People.Patient;

import javax.persistence.*;

@Entity
@Table(name = "treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String treatmentDate;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Treatment(String treatmentDate, Disease disease, Patient patient) {
        this.treatmentDate = treatmentDate;
        this.disease = disease;
        this.patient = patient;
    }

    public Treatment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(String treatment_date) {
        this.treatmentDate = treatment_date;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
