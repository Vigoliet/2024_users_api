package com.example._users_api.controllers;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/conflicts")
    public String postConflicts(){
        return "Posting conflicts";
    }

    @PatchMapping("/conflicts")
    public String patchConflicts(){
        return "Patching conflicts";
    }
}
