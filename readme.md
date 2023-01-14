수강 내용 노트필기

* SQL 중심적인 개발의 대표적인 문제점
  1. 연관관계를 바라보는 패러다임의 불일치
     * class Member { 
       * String id;
       * String userName;
       * Long teamId; <-> Team team;
       } 
  2. sql은 처음 select하는 범위에 따라 탐색범위가 결정됨
     * member.getTeam();
     * member.getOrder().getDelivery();
     * 모든 객체를 미리 로딩할순 없다.
  3. db계층에서의 비교를 java에서 사용할수 없다.
     * member1 = memberDAO.getMember(id)
     * member2 = memberDAO.getMember(id)
     * member1 != member2

* JPA를 사용해야하는 이유
  1. SQL 중심적인 개발에서 객체 중심으로 개발
  2. 생산성, 유지보수, 성능
  3. 패러다임의 불일치 해결
  4. 데이터 접근 추상화와 벤더 독립성
  5. 표준

===

* persistence.xml 
  * dialect(방언) : sql 표준과 맞지않는 db별 기능명칭을 한번에 적용할수 있도록 함.


===

* jpa 구동방식
  1. Persistence가 설정 문서를 조회
  2. EntityManagerFactory에게 em을 생성할것을 지시
  3. 1개 이상의 em 생성
  4. 주의사항
     1. em은 쓰레드간 공유하면 안되고, 사용후 버려야 한다.
     2. jpa의 모든 데이터 변경은 트랜잭션 안에서 실행된다.

===

* JPQL - 추상화된 SQL 쿼리로 기능을 제공하는 객체지향SQL
  1. 단순 조회가 아닌, 범주나 조건을 두고 검색할때 사용
  2. 테이블 대상이 아닌 객체 대상으로 쿼리를 짠다