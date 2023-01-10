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

        /**
         * 코드 작성 부분 시작 - db와 주고받는 내용
         */
        Member member = new Member();
        member.setId(2L);
        member.setName("HelloB");

        em.persist(member);
        /**
         * 코드 작성 부분 끝
         */

        tx.commit();
        em.close();
        emf.close();
    }
}
