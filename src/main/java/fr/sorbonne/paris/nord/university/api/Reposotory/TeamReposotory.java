package fr.sorbonne.paris.nord.university.api.Reposotory;
import fr.sorbonne.paris.nord.university.api.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamReposotory extends JpaRepository<Team, Long> {

}
