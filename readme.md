수강 내용 노트필기

persistence.xml
dialect(방언) : sql 표준과 맞지않는 db별 기능명칭을 한번에 적용할수 있도록 함.

jpa 구동방식
1. Persistence가 설정 문서를 조회
2. EntityManagerFactory에게 em을 생성할것을 지시
3. 1개 이상의 em 생성

주의사항
1. em은 쓰레드간 공유하면 안되고, 사용후 버려야 한다.
2. jpa의 모든 데이터 변경은 트랜잭션 안에서 실행된다.