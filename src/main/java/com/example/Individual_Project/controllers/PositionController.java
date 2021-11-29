package com.example.Individual_Project.controllers;

import com.example.Individual_Project.Repo.Position.PositionRepository;
import com.example.Individual_Project.models.Documents.Passport;
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
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/position")
    public String positionMain(Position position, Model model) {
        Iterable<Position> positions = positionRepository.findAll();
        model.addAttribute("positions", positions);
        return "/Position/position-view";
    }

    @PostMapping("/position/result")
    public String positionSearch(@RequestParam String positionName, Model model) {
        List<Position> result2 = positionRepository.findByPositionName(positionName);
        model.addAttribute("result3", result2);
        return "main-view";
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

    @GetMapping("/position/{id}/remove")
    public String positionDelete(@PathVariable(value = "id") Long id,
                               Model model) {
        Position position = positionRepository.findById(id).orElseThrow();
        positionRepository.delete(position);
        return "redirect:/position";
    }

    @GetMapping("/position/{id}/edit")
    public String positionEdit(@PathVariable(value = "id") Long id,
                             Position position, Model model) {
        if (!positionRepository.existsById(id))
            return "redirect:/position";
        Optional<Position> positions = positionRepository.findById(id);
        ArrayList<Position> res = new ArrayList<>();
        positions.ifPresent(res::add);
        model.addAttribute("positions", res);
        return "/Position/position-edit";
    }

    @PostMapping("/position/{id}/edit")
    public String positionUpdate(@PathVariable(value = "id") Long id,
                               @Valid Position position,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            Optional<Position> positionOptional = positionRepository.findById(id);
            ArrayList<Position> res = new ArrayList<>();
            positionOptional.ifPresent(res::add);
            model.addAttribute("positionOptional", res);
            return "/Position/position-edit";
        } else {
            positionRepository.save(position);
            return "redirect:/position";
        }
    }
}