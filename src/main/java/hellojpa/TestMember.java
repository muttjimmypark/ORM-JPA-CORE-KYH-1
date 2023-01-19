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
public class TestMember {

    @Id
    @GeneratedValue
    @Column(name = "TMEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    private int age;

    @Column(name = "TTEAM_ID")
    private Long teamId;

}
