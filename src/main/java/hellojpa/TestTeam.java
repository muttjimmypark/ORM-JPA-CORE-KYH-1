package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class TestTeam {

    @Id
    @GeneratedValue
    @Column(name = "TTEAM_ID")
    private Long id;

    private String name;
}

