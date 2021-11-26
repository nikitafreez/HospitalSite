package com.example.Individual_Project.controllers;

import com.example.Individual_Project.Repo.DocumentsRepo.OMSRepository;
import com.example.Individual_Project.Repo.DocumentsRepo.PassportRepository;
import com.example.Individual_Project.Repo.Position.PositionRepository;
import com.example.Individual_Project.models.Documents.OMS;
import com.example.Individual_Project.models.Documents.Passport;
import com.example.Individual_Project.models.Position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/position")
    public String positionMain(Position position, Model model) {
        Iterable<Position> positions = positionRepository.findAll();
        model.addAttribute("positions", positions);
        return "/Position/position-view";
    }

    @PostMapping("/position/add")
    public String positionAdd(@Valid Position position,
                              BindingResult bindingResult,
                              @RequestParam String positionName) {
        if (bindingResult.hasErrors())
            return "/Position/position-view";
        List<Position> res = positionRepository.findByPositionName(positionName);
        if (res.size() > 0) {
            ObjectError error = new ObjectError("positionName", "Такая должность уже существует");
            bindingResult.addError(error);
            return "/Position/position-view";
        } else {
            positionRepository.save(position);
            return "redirect:/position";
        }
    }
}
