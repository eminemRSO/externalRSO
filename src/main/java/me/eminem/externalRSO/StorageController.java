package me.eminem.externalRSO;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class StorageController {

    TaskService taskService;

    ModelMapper modelMapper;

    public StorageController(TaskService taskService) {
        modelMapper = new ModelMapper();
        this.taskService = taskService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/returnPokemon/{pokename}")
    public String returnPokemon(@PathVariable String pokename){
        return taskService.returnPokemon(pokename);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path="/getPokemon/{pokename}")
    public String getPokemon(@PathVariable String pokename){
        return taskService.getPokemon(pokename);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path="/isPokemon/{pokename}")
    public boolean isPokemon(@PathVariable String pokename){
        return taskService.isPokemon(pokename);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path="/getPicPokemon/{pokename}")
    public String getPicPokemon(@PathVariable String pokename){
        return taskService.getPicPokemon(pokename);
    }
}