package com.example._users_api.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConflictsController {

    @GetMapping("/conflicts")
    public String getConflicts(){
        return "Getting conflicts";
    }

    @DeleteMapping("/conflicts")
    public String deleteConflicts(){
        return "Deleting conflicts";
    }
}
