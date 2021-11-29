package com.example.Individual_Project.controllers;

import com.example.Individual_Project.Repo.Ambulance.AmbulanceCallRepository;
import com.example.Individual_Project.Repo.Ambulance.AmbulanceCarRepository;
import com.example.Individual_Project.Repo.Documents.PassportRepository;
import com.example.Individual_Project.Repo.People.WorkerRepository;
import com.example.Individual_Project.models.Ambulance.Ambulance_call;
import com.example.Individual_Project.models.Ambulance.Ambulance_car;
import com.example.Individual_Project.models.Documents.Passport;
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
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AmbulanceController {
    @Autowired
    private AmbulanceCarRepository ambulanceCarRepository;
    @Autowired
    private AmbulanceCallRepository ambulanceCallRepository;
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private PassportRepository passportRepository;

    @GetMapping("/ambulanceCar")
    public String ambulacneCarMain(Ambulance_car ambulance_car, Model model) {
        Iterable<Ambulance_car> ambulanceCars = ambulanceCarRepository.findAll();
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers", workers);
        model.addAttribute("ambulanceCars", ambulanceCars);
        return "/Ambulance/ambulanceCar-view";
    }

    @PostMapping("/ambulanceCar/add")
    public String ambulacneCarAdd(@Valid Ambulance_car ambulance_car,
                                  BindingResult bindingResult,
                                  @RequestParam String passport,
                                  @RequestParam String carModel,
                                  @RequestParam String ambulanceCarNum) {
        if (bindingResult.hasErrors()) {
            return "/Ambulance/ambulanceCar-view";
        }
        Worker worker1 = workerRepository.findByPassport(passportRepository.findByPassSeriaAndPassNum(passport.substring(0, 4), passport.substring(5, 11)));
        Ambulance_car ambulanceCar = new Ambulance_car(ambulanceCarNum, carModel, worker1);
        ambulanceCarRepository.save(ambulanceCar);
        return "redirect:/ambulanceCar";
    }

    @GetMapping("/ambulanceCall")
    public String ambulanceCallMain(Ambulance_call ambulance_call, Model model) {
        Iterable<Ambulance_call> ambulanceCalls = ambulanceCallRepository.findAll();
        Iterable<Ambulance_car> ambulanceCars = ambulanceCarRepository.findAll();
        model.addAttribute("ambulanceCalls", ambulanceCalls);
        model.addAttribute("ambulanceCars", ambulanceCars);
        return "/Ambulance/ambulanceCall-view";
    }

    @PostMapping("/ambulanceCall/add")
    public String ambulanceCallAdd(@Valid Ambulance_call ambulance_call,
                                   BindingResult bindingResult,
                                   @RequestParam String ambulanceCarNum,
                                   @RequestParam String callAddress,
                                   @RequestParam String callDate,
                                   @RequestParam String callDescription) {
        if (bindingResult.hasErrors()) {
            return "/Ambulance/ambulanceCall-view";
        }
        Ambulance_car ambulanceCar = ambulanceCarRepository.findByAmbulanceCarNum(ambulanceCarNum);
        Ambulance_call ambulanceCall = new Ambulance_call(callAddress, callDate, callDescription, ambulanceCar);
        ambulanceCallRepository.save(ambulanceCall);
        return "redirect:/ambulanceCall";
    }

    @GetMapping("/ambulanceCar/{id}/remove")
    public String ambulanceCarDelete(@PathVariable(value = "id") Long id,
                                     Model model) {
        Ambulance_car ambulance_car = ambulanceCarRepository.findById(id).orElseThrow();
        ambulanceCarRepository.delete(ambulance_car);
        return "redirect:/ambulanceCar";
    }

    @GetMapping("/ambulanceCall/{id}/remove")
    public String ambulanceCallDelete(@PathVariable(value = "id") Long id,
                                     Model model) {
        Ambulance_call ambulance_call = ambulanceCallRepository.findById(id).orElseThrow();
        ambulanceCallRepository.delete(ambulance_call);
        return "redirect:/ambulanceCall";
    }

    @GetMapping("/ambulanceCall/{id}")
    public String ambulanceCallDetail(@PathVariable(value = "id") Long id,
                                      Model model){
        Optional<Ambulance_call> ambulanceCall = ambulanceCallRepository.findById(id);
        ArrayList<Ambulance_call> res = new ArrayList<>();
        ambulanceCall.ifPresent(res::add);
        model.addAttribute("ambulanceCall", res);

        return "Ambulance/ambulanceCall-detail";
    }
}
