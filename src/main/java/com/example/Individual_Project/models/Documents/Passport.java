package com.example.Individual_Project.models.Documents;

import com.example.Individual_Project.models.People.Worker;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "\\d{6}",
            message = "Серия должна состоять из 6 цифр")
    private String passNum;

    @Pattern(regexp = "\\d{4}",
            message = "Номер должен состоять из 4 цифр")
    private String passSeria;

    @NotEmpty(message = "Имя не должно быть пустым")
    @NotNull(message = "Имя не должно быть пустым")
    @Size(min = 1, max = 25, message = "Имя должно содержать от 1 до 25 букв")
    private String firstName;

    @NotEmpty(message = "Фамилия не должна быть пустым")
    @NotNull(message = "Фамилия не должна быть пустым")
    @Size(min = 1, max = 25, message = "Фамилия должна содержать от 1 до 25 букв")
    private String secondName;

    @Size(max = 25, message = "Отчество должно содержать до 25 букв")
    private String middleName;

    private String birthDate;

    @NotEmpty(message = "Кем выдано не должно быть пустым")
    @NotNull(message = "Кем выдано не должно быть пустым")
    private String givenBy;

    @OneToOne(mappedBy = "passport")
    private Worker owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassNum() {
        return passNum;
    }

    public void setPassNum(String passNum) {
        this.passNum = passNum;
    }

    public String getPassSeria() {
        return passSeria;
    }

    public void setPassSeria(String passSeria) {
        this.passSeria = passSeria;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }

    public Worker getOwner() {
        return owner;
    }

    public void setOwner(Worker owner) {
        this.owner = owner;
    }

    public Passport(String passNum, String passSeria, String firstName, String secondName, String middleName, String birthDate, String givenBy) {
        this.passNum = passNum;
        this.passSeria = passSeria;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.givenBy = givenBy;
    }

    public Passport() {
    }
}
