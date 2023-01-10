package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

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
            Member foundMember = em.find(Member.class, 1L);
            foundMember.setName("HelloJPA");
//            em.persist(foundMember); 필요없다
            /**
             * jpa를 통해 가져온 엔티티의 변경사항은
             * 커밋시점에 확인되어 update쿼리가 알아서 날아가게 된다
             */

            tx.commit();

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();

        }


        emf.close();
    }
}
