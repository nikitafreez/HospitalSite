package com.example.Individual_Project.controllers;

import com.example.Individual_Project.Repo.Documents.OMSRepository;
import com.example.Individual_Project.Repo.Documents.PassportRepository;
import com.example.Individual_Project.Repo.People.WorkerRepository;
import com.example.Individual_Project.Repo.Position.PositionRepository;
import com.example.Individual_Project.models.Documents.OMS;
import com.example.Individual_Project.models.Documents.Passport;
import com.example.Individual_Project.models.People.Worker;
import com.example.Individual_Project.models.Position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PeopleController {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private PassportRepository passportRepository;
    @Autowired
    private OMSRepository omsRepository;
    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/worker")
    public String workerMain(Worker worker, Model model) {
        Iterable<Position> positions = positionRepository.findAll();
        Iterable<OMS> oms = omsRepository.findAll();
        Iterable<Passport> passports = passportRepository.findAll();
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers", workers);
        model.addAttribute("passports", passports);
        model.addAttribute("oms", oms);
        model.addAttribute("positions", positions);
        return "/People/worker-view";
    }

    @PostMapping("/worker/add")
    public String workerAdd(@RequestParam String position,
                            @RequestParam String oms,
                            @RequestParam String passport) {
            Position position1 =positionRepository.findPositionByPositionName(position);
            OMS oms1 = omsRepository.findOMSByOmsNum(oms);
            Passport passport1 = passportRepository.findByPassSeriaAndPassNum(passport.substring(0,4), passport.substring(5,11));
            Worker worker = new Worker(passport1, oms1, position1);
            workerRepository.save(worker);
            return "redirect:/worker";
    }
}
