package com.project.spring_demo.Basic_Information.controller;

import com.project.spring_demo.Basic_Information.model.Information;
import com.project.spring_demo.Basic_Information.service.InformationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Information")
public class Information_controller {
    InformationService informationService;

    public Information_controller(InformationService informationService) {
        this.informationService = informationService;
    }

    @PostMapping
    public String CreateInformationrDetails(@Valid @RequestBody Information information) {
        informationService.createInformation(information);
        return "Basic Information Created Successfully";
    }

    @PutMapping
    public String updateInformationDetails(@Valid @RequestBody Information information) {
        informationService.updateInformation(information);
        return "Basic Information Updated Successfull";
    }

    @DeleteMapping("{informationId}")
    public String deleteInformationDetails(@PathVariable("informationId") String informationId) {
        informationService.deleteInformation(informationId);
        return "Information Deleted Successfully";
    }

    @GetMapping("{informationId}")
    public Information getInformationDetails(@PathVariable("informationId") String informationId) {
        return informationService.getInformation(informationId);
    }
}
