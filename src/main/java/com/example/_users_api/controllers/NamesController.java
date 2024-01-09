package com.example._users_api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class NamesController {
    @GetMapping("/names")
    public String getName(){
        return "Your name is Vigor...";
    }

    @PostMapping("/names")
    public String postName(@RequestBody String name){
        return "Posting your name..." + name;
    }

    @PutMapping("/names")
    public String putName(){
        return "Putting your name...";
    }

    @DeleteMapping("names")
    public String deleteName(){
        return "Deleting your name...";
    }

}
