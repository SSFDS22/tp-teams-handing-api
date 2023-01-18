package fr.sorbonne.paris.nord.university.api.Service;

import fr.sorbonne.paris.nord.university.api.Entity.Team;
import fr.sorbonne.paris.nord.university.api.Reposotory.TeamReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamService {
    @Autowired
    TeamReposotory myReposotory;

    public List<Team> getListTeam(){
        return myReposotory.findAll();
    }
    public Team getById( long id){
       return  myReposotory.findById(id).get();
    }
    public Team addTeam(Team team) {
        return myReposotory.save(team);
    }
    public Team updateTeam(Long id, String name) {
        Team team = myReposotory.findById(id).orElseThrow();
        team.setName(name);
        return myReposotory.save(team);
    }
    public Team deleteTeam(Long id, String name) {
        Team team = myReposotory.findById(id).orElseThrow();
        myReposotory.delete(team);
        return team;
    }
}
