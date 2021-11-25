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
    private String disease_name;

    @NotNull(message = "Метод лечения не должен быть пустым")
    @NotEmpty(message = "Метод лечения не должен быть пустым")
    @Size(max = 150, message = "Метод лечения должен содержать до 150 символов")
    private String treatment_method;

    @OneToMany(mappedBy = "disease", fetch = FetchType.EAGER)
    private Collection<Treatment> treatments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisease_name() {
        return disease_name;
    }

    public void setDisease_name(String disease_name) {
        this.disease_name = disease_name;
    }

    public String getTreatment_method() {
        return treatment_method;
    }

    public void setTreatment_method(String treatment_method) {
        this.treatment_method = treatment_method;
    }

    public Collection<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Collection<Treatment> treatments) {
        this.treatments = treatments;
    }

    public Disease(String disease_name, String treatment_method) {
        this.disease_name = disease_name;
        this.treatment_method = treatment_method;
    }

    public Disease() {
    }
}
