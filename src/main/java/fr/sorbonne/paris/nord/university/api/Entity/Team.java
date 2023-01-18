package fr.sorbonne.paris.nord.university.api.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="team")
public class Team {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="name")
        private String name;
        @Column(name="slogan")
        private String slogan;

        public Team() {}

        public Team(String name, String slogan) {
            this.name = name;
            this.slogan = slogan;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id.equals(team.id) && Objects.equals(name, team.name) && Objects.equals(slogan, team.slogan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, slogan);
    }

    public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        @Override
        public String toString() {
            return "Team{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", slogan='" + slogan + '\'' +
                    '}';
        }
}
