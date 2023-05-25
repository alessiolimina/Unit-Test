package it.develhope.Unit.Test.controllers;


import it.develhope.Unit.Test.entities.Utente;
import it.develhope.Unit.Test.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UtenteController {

    @Autowired
    private UtenteRepository utenteRepository;

    @PostMapping("/users")
    public @ResponseBody
    Utente create(@RequestBody Utente utente){
        return utenteRepository.save(utente);
    }


    @GetMapping("/users")
    public @ResponseBody
    List<Utente> getAll(){
        return utenteRepository.findAll();
    }


    @GetMapping("/users/{id}")
    public @ResponseBody Utente getSingle(@PathVariable long id){
        Optional<Utente> utente =  utenteRepository.findById(id);
        if(utente.isPresent()){
            return utente.get();
        } else {
            return null;
        }
    }


    @PutMapping("users/{surname}")
    public @ResponseBody Utente updateSurname(@PathVariable String surname, @RequestBody Utente utente){
        utente.setSurname(surname);
        return utenteRepository.save(utente);
    }


    @DeleteMapping("/users")
    public void deleteUser(){
        utenteRepository.deleteAll();
    }
}
