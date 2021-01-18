package me.eminem.externalRSO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    String returnPokemon(String pokename){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://pokeapi.co/api/v2/pokemon/"+pokename;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        return response.getBody();
    }

    String getPokemon(String pokename){
        return "place holder tuki";
    }

    boolean isPokemon(String pokename){
        try {
            RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl
                    = "https://pokeapi.co/api/v2/pokemon/" + pokename;
            ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    String getPicPokemon(String pokename){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://pokeapi.co/api/v2/pokemon/"+pokename;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        String stringec = response.getBody();

        String wordToFind = "official-artwork";
        int position = stringec.indexOf(wordToFind);
        int positionEnd = stringec.indexOf(".png\"}}",position+wordToFind.length());

        String url = stringec.substring(position+36, positionEnd+4);

        return url;
    }
}
