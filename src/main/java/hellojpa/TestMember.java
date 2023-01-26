package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

//    @Column(name = "TTEAM_ID")
//    private Long teamId;
    // 단방향 연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "TTEAM_ID")
    private TestTeam team;

}
