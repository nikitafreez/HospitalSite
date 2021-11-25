package com.example.Individual_Project.models.Medicine;

import com.example.Individual_Project.models.People.Patient;

import javax.persistence.*;

@Entity
@Table(name = "treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String treatment_date;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Treatment(String treatment_date, Disease disease, Patient patient) {
        this.treatment_date = treatment_date;
        this.disease = disease;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreatment_date() {
        return treatment_date;
    }

    public void setTreatment_date(String treatment_date) {
        this.treatment_date = treatment_date;
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
