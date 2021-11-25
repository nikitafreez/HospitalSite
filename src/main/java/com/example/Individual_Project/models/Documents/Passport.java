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
    private Integer pass_Num;

    @Pattern(regexp = "\\d{4}",
            message = "Номер должен состоять из 4 цифр")
    private Integer pass_Seria;

    @NotEmpty(message = "Имя не должно быть пустым")
    @NotNull(message = "Имя не должно быть пустым")
    @Size(min = 1, max = 25, message = "Имя должно содержать от 1 до 25 букв")
    private String first_name;

    @NotEmpty(message = "Фамилия не должна быть пустым")
    @NotNull(message = "Фамилия не должна быть пустым")
    @Size(min = 1, max = 25, message = "Фамилия должна содержать от 1 до 25 букв")
    private String second_name;

    @Size(max = 25, message = "Отчество должно содержать до 25 букв")
    private String middle_name;

    private String birth_date;

    @NotEmpty(message = "Кем выдано не должно быть пустым")
    @NotNull(message = "Кем выдано не должно быть пустым")
    private String given_by;

    @OneToOne(optional = false, mappedBy = "passport")
    private Worker owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPass_Num() {
        return pass_Num;
    }

    public void setPass_Num(Integer pass_Num) {
        this.pass_Num = pass_Num;
    }

    public Integer getPass_Seria() {
        return pass_Seria;
    }

    public void setPass_Seria(Integer pass_Seria) {
        this.pass_Seria = pass_Seria;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getGiven_by() {
        return given_by;
    }

    public void setGiven_by(String given_by) {
        this.given_by = given_by;
    }

    public Passport() {
    }

    public Passport(Integer pass_Num, Integer pass_Seria, String first_name, String second_name, String middle_name, String birth_date, String given_by) {
        this.pass_Num = pass_Num;
        this.pass_Seria = pass_Seria;
        this.first_name = first_name;
        this.second_name = second_name;
        this.middle_name = middle_name;
        this.birth_date = birth_date;
        this.given_by = given_by;
    }

    public Worker getOwner() {
        return owner;
    }

    public void setOwner(Worker owner) {
        this.owner = owner;
    }
}
