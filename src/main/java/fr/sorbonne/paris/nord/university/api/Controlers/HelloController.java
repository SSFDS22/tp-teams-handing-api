package fr.sorbonne.paris.nord.university.api.Controlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.sorbonne.paris.nord.university.api.Entity.Team;
import fr.sorbonne.paris.nord.university.api.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController {
    @Autowired
    TeamService myService;
    @GetMapping("/hello")
    public String hello(){
        return "hello" + myService.getListTeam();
    }
  @GetMapping("/equipeList")
    public String teamList(){
        return " Mes Equipe "+ myService.getListTeam();
    }
    @GetMapping("/equipeByid")
    public String teamById(@RequestParam String id){
        long id1=Long.parseLong(id);
        Team myTeam = new Team();
        myTeam= myService.getById(id1);

        ObjectMapper mapper = new ObjectMapper();

        try {
            // convertir l'objet Java en chaîne JSON
            String jsonString = mapper.writeValueAsString(myTeam);
            return " Equipe avec cet id  avec json  "+jsonString;
            // utiliser la chaîne JSON
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
            //utiliser json

        return " Equipe avec cet id  "+ myService.getById(id1)+"\n";
    }
}
