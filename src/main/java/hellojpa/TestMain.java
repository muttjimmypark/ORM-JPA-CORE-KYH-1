package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMain {

    public static void main(String[] args) {

        //앱 실행시 딱 하나만 생성되어야 함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //한 트랜잭션마다 생성되어야 함
        //ex> 연결을 획득해서 동작을 하고 close하는 하나의 흐름마다
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //생성
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");

            //수정
//            Member foundMember = em.find(Member.class, 1L);
//            foundMember.setName("HelloJPA");
            /**
             * em.persist(foundMember); 필요없다
             * jpa를 통해 가져온 엔티티의 변경사항은
             * 커밋시점에 확인되어 update쿼리가 알아서 날아가게 된다
             */

            //jpql
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(5)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }
            /**
             * setFirstResult(n) : idx n번 부터
             * setMaxResult(m) : m개씩 호출한다
             */


            /**
             * 연관관계 매핑 기초  [객체 개념에서의 참조 -매핑- 테이블 개념에서의 외래키]
             * 매핑이 필요한 이유 - 객체를 테이블에 맞춰 데이터중심으로 모델링하면, 협력관계를 만들 수 없다.
             */
//            TestTeam team = new TestTeam();
//            team.setName("TeamA");
//            em.persist(team);
//
//            TestMember member = new TestMember();
//            member.setName("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            // 객체지향스럽지 않은 방식으로 호출할수 밖에 없다
//            TestMember findMember = em.find(TestMember.class, member.getId());
//            Long findTeamId = findMember.getTeamId();
//            TestTeam findTeam = em.find(TestTeam.class, findTeamId);


            /**
             * 연관관계 매핑 기초 - 단방향 연관관계
             * 연관관계가 매핑되면 객체지향 스러운 호출이 가능해진다
             */
            TestTeam team = new TestTeam();
            team.setName("TeamA");
            em.persist(team);

            TestMember member = new TestMember();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

            TestMember findMember = em.find(TestMember.class, member.getId());
            TestTeam findTeam = findMember.getTeam();
            System.out.println("findTeam.getName() = " + findTeam.getName());

            //연관관계 수정도 객체지향적으로 간단한 적용이 가능
//            TestTeam anotherTeam = em.find(TestTeam.class, 100L);
//            findMember.setTeam(anotherTeam);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();

        }


        emf.close();
    }
}
