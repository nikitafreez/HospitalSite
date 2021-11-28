package com.example.Individual_Project.models.Medicine;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "disease")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Название болезни не должно быть пустым")
    @NotEmpty(message = "Название болезни не должно быть пустым")
    @Size(min = 2, max = 30, message = "Название болезни должно содержать от 2 до 30 символов")
    private String diseaseName;

    @NotNull(message = "Метод лечения не должен быть пустым")
    @NotEmpty(message = "Метод лечения не должен быть пустым")
    @Size(max = 150, message = "Метод лечения должен содержать до 150 символов")
    private String treatmentMethod;

    @OneToMany(mappedBy = "disease", fetch = FetchType.EAGER)
    private Collection<Treatment> treatments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String disease_name) {
        this.diseaseName = disease_name;
    }

    public String getTreatmentMethod() {
        return treatmentMethod;
    }

    public void setTreatmentMethod(String treatment_method) {
        this.treatmentMethod = treatment_method;
    }

    public Collection<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Collection<Treatment> treatments) {
        this.treatments = treatments;
    }

    public Disease(String diseaseName, String treatmentMethod) {
        this.diseaseName = diseaseName;
        this.treatmentMethod = treatmentMethod;
    }

    public Disease() {
    }
}
