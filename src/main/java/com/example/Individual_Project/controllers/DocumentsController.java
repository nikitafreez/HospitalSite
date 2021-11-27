package com.example.Individual_Project.controllers;

import com.example.Individual_Project.Repo.Ambulance.AmbulanceCarRepository;
import com.example.Individual_Project.Repo.Documents.OMSRepository;
import com.example.Individual_Project.Repo.Documents.PassportRepository;
import com.example.Individual_Project.Repo.People.WorkerRepository;
import com.example.Individual_Project.models.Ambulance.Ambulance_car;
import com.example.Individual_Project.models.Documents.OMS;
import com.example.Individual_Project.models.Documents.Passport;
import com.example.Individual_Project.models.People.Worker;
import com.example.Individual_Project.models.Position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DocumentsController {
    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private OMSRepository omsRepository;

    @GetMapping("/passport")
    public String passportMain(Passport passport, Model model) {
        Iterable<Passport> passports = passportRepository.findAll();
        model.addAttribute("passports", passports);
        return "/Documents/passports-view";
    }

    @PostMapping("/passport/add")
    public String passportAdd(@Valid Passport passport,
                              BindingResult bindingResult,
                              @RequestParam String passNum,
                              @RequestParam String passSeria) {
        if (bindingResult.hasErrors())
            return "/Documents/passports-view";

        List<Passport> res = passportRepository.findByPassNumAndPassSeria(passNum, passSeria);
        if (res.size() > 0) {
            ObjectError error = new ObjectError("NumSeria", "Такой паспрорт уже есть");
            bindingResult.addError(error);
            return "/Documents/passports-view";
        } else {
            passportRepository.save(passport);
            return "redirect:/passport";
        }
    }

    @GetMapping("/oms")
    public String omsMain(OMS OMS, Model model) {
        Iterable<OMS> oms = omsRepository.findAll();
        model.addAttribute("oms", oms);
        return "/Documents/oms-view";
    }

    @PostMapping("/oms/add")
    public String omsAdd(@Valid OMS oms,
                         BindingResult bindingResult,
                         @RequestParam String omsNum) {
        if (bindingResult.hasErrors())
            return "/Documents/oms-view";

        List<OMS> res = omsRepository.findByOmsNum(omsNum);
        if (res.size() > 0) {
            ObjectError error = new ObjectError("omsNum", "Такой полюс уже есть");
            bindingResult.addError(error);
            return "/Documents/oms-view";
        } else {
            omsRepository.save(oms);
            return "redirect:/oms";
        }
    }

    @GetMapping("/oms/{id}/remove")
    public String omsDelete(@PathVariable(value = "id") Long id,
                                 Model model) {
        OMS oms = omsRepository.findById(id).orElseThrow();
        omsRepository.delete(oms);
        return "redirect:/oms";
    }

    @GetMapping("/passport/{id}/remove")
    public String passportDelete(@PathVariable(value = "id") Long id,
                                 Model model) {
        Passport passport = passportRepository.findById(id).orElseThrow();
        passportRepository.delete(passport);
        return "redirect:/passport";
    }
}
