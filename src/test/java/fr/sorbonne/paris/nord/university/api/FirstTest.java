package fr.sorbonne.paris.nord.university.api;

import fr.sorbonne.paris.nord.university.api.Entity.Team;
import fr.sorbonne.paris.nord.university.api.Reposotory.TeamReposotory;
import fr.sorbonne.paris.nord.university.api.Service.TeamService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class FirstTest {
    @Autowired
    TeamService myservice;

    @Autowired
    TeamReposotory myTeamReposostory;
    @Test
    public void testgetById(){
        //Long l= Long.valueOf(22);
        Team myteam=new Team("salif","premier");
        myteam.setId((long) 5);
        myservice.addTeam(myteam);
        Team baseTeam=myTeamReposostory.findAll().stream().filter(t->t.getName().equals("salif")).findFirst().get();
        assertEquals(myteam,baseTeam);
    }
}
