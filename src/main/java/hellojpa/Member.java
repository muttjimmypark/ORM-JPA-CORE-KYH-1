package hellojpa;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "MBR")
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
//@TableGenerator(
//        name = "member_table_generator",
//        table = "my_seqences",
//        pkColumnValue = "member_seq", allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    // Long형 + 대체키 + 키 생성전략 사용을 권장 (비즈니스에 사용되는값을 활용하는것은 비추)
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_table_generator")
    private Long id;

    @Column(name = "name", nullable = false)
    private String userName;


    /* 필드 매핑 예제 시작

    private Integer age;

    // enum자료형을 쓸땐 무조건 STRING옵션을 부여. ORDINAL 옵션(기본값) 절대 사용 x
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // db는 날짜,시간,날짜시간 등으로 날짜의 자료형이 다양하므로 지정해줘야함
    // java8 이후 최신 하이버네이트환경에서는
    // 필드에 LocalDate 또는 LocalDateTime 자료형을 사용하면
    // 신경쓸 필요없이 생략이 가능한 애노테이션이다.
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // clob 자료형으로 컬럼 생성
    @Lob
    private String description;

    // 컬럼에 매칭하고싶지않은 필드
    @Transient
    private int temp;

    필드 매핑 예제 끝 */
}
