package me.eminem.externalRSO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    String getPokemon(String pokename){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://pokeapi.co/api/v2/pokemon/"+pokename;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        return response.getBody();
    }
}
