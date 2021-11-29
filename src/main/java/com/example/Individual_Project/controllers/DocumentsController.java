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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @PostMapping("/passport/result")
    public String passportSearch(@RequestParam String secondName, Model model) {
        List<Passport> result2 = passportRepository.findBySecondName(secondName);
        model.addAttribute("result2", result2);
        return "main-view";
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

    @GetMapping("/passport/{id}")
    public String passportDetail(@PathVariable(value = "id") Long id,
                                 Model model){
        Optional<Passport> passport = passportRepository.findById(id);
        ArrayList<Passport> res = new ArrayList<>();
        passport.ifPresent(res::add);
        model.addAttribute("passport", res);

        return "Documents/passports-detail";
    }

    @GetMapping("/oms/{id}/edit")
    public String omsEdit(@PathVariable(value = "id") Long id,
                               OMS oms, Model model) {
        if (!omsRepository.existsById(id))
            return "redirect:/oms";
        Optional<OMS> oms1 = omsRepository.findById(id);
        ArrayList<OMS> res = new ArrayList<>();
        oms1.ifPresent(res::add);
        model.addAttribute("oms1", res);
        return "/Documents/oms-edit";
    }

    @PostMapping("/oms/{id}/edit")
    public String omsUpdate(@PathVariable(value = "id") Long id,
                                 @Valid OMS oms,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            Optional<OMS> omsOptional = omsRepository.findById(id);
            ArrayList<OMS> res = new ArrayList<>();
            omsOptional.ifPresent(res::add);
            model.addAttribute("omsOptional", res);
            return "/Documents/oms-edit";
        } else {
            omsRepository.save(oms);
            return "redirect:/oms";
        }
    }

    @GetMapping("/passport/{id}/edit")
    public String passportEdit(@PathVariable(value = "id") Long id,
                               Passport passport, Model model) {
        if (!passportRepository.existsById(id))
            return "redirect:/passport";
        Optional<Passport> passports = passportRepository.findById(id);
        ArrayList<Passport> res = new ArrayList<>();
        passports.ifPresent(res::add);
        model.addAttribute("passports", res);
        return "/Documents/passports-edit";
    }

    @PostMapping("/passport/{id}/edit")
    public String positionUpdate(@PathVariable(value = "id") Long id,
                                 @Valid Passport passport,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            Optional<Passport> passportOptional = passportRepository.findById(id);
            ArrayList<Passport> res = new ArrayList<>();
            passportOptional.ifPresent(res::add);
            model.addAttribute("passportOptional", res);
            return "/Documents/passports-edit";
        } else {
            passportRepository.save(passport);
            return "redirect:/passport";
        }
    }
}
