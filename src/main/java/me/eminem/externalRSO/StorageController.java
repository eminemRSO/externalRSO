package me.eminem.externalRSO;

import org.modelmapper.ModelMapper;
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



    @GetMapping(path="/isPokemon/{pokename}")
    public String isPokemon(@PathVariable String pokename){
        return taskService.getPokemon(pokename);
    }
}