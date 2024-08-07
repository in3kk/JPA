package jpql;



import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMainJPQL {
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성 (db연결) db당 하나만 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //엔티티 매니저 생성 > 고객의 요청이 있을때마다 생성하고 요청이 끝나면 삭제 반복 스레드간 공유 절대 금지
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{
            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);
            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member = new Member();
            member.setUsername("회원1");
//            member.setAge(10);
            member.setTeam(teamA);
//            member.setType(MemberType.ADMIN);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);


            em.persist(member);
            em.persist(member2);
            em.persist(member3);
//            for(int i = 100; i >0; i--){
//                Member member = new Member();
//                member.setUsername("member"+i);
//                member.setAge(i);
//                em.persist(member);
//            }
            em.flush();
            em.clear();
//            TypedQuery<Member> query1 = em.createQuery("select m from Member m",Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m",String.class);
//            Query query3 = em.createQuery("select m.age, m.username from Member m");
//            List<Member> resultList = query1.getResultList();
//            for(Member member1 : resultList){
//                System.out.println(member1);
//            }
//            TypedQuery<Member> query1 = em.createQuery("select m from Member m where m.username=:username",Member.class);
//            query1.setParameter("username","kim");
//
//            TypedQuery<Member> query2 = em.createQuery("select m from Member m where m.username=?1",Member.class);
//            query2.setParameter(1,"kim");
//            Member result = query1.getSingleResult();
//            List<Team> result = em.createQuery("select m.team from Member m",Team.class).getResultList();//엔티티 프로젝션
//            List<Team> result2 = em.createQuery("select t from Member m join m.team t ",Team.class).getResultList();//해당 방법을 더 권정한다.
//            List<Address> result = em.createQuery("select o.address from Order o",Address.class).getResultList();//임베디드 타입 프로젝션

//            Address findMember = result.get(0);
//            Team findTeam = result2.get(0);
//            findMember.setAge(20);
//            List resultList = em.createQuery("select m.username,m.age from Member m").getResultList();// 스칼라 타입 프로젝션
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//            System.out.println("result = "+ result[0]);
//            System.out.println("result = "+ result[1]);
//            List<Object[]> resultList = em.createQuery("select m.username,m.age from Member m").getResultList();// 스칼라 타입 프로젝션
//            Object[] result = resultList.get(0);
//            System.out.println("result = "+ result[0]);
//            System.out.println("result = "+ result[1]);
//            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username,m.age) from Member m", MemberDTO.class).getResultList();// 스칼라 타입 프로젝션 가장 권장하는 방법
//            //전체를 조회할 때는 m을 사용하면 되지만 특정 칼럼만을 원한다면 new 도메인.클래스명(매핑정보)를 입력한다. 이는 해당 DTO의 생성자를 통해 호출된다.
//            MemberDTO result = resultList.get(0);
//            System.out.println("result = "+ result.getUsername());
//            System.out.println("result = "+ result.getAge());

            //페이징
//            List<Member> result = em.createQuery("select m from Member m order by m.age desc",Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
//            System.out.println("result.size = "+result.size());
//            for(Member member1 : result){
//                System.out.println("member = "+member1.getUsername()+" : "+member1.getAge());
//            }

            //조인 inner 조인시 'inner' 생략 가능, outer 조인시 'left' or 'right' 작성시 'outer' 생략 가능
//            String query = "select m from Member m inner join m.team t";
//            String query = "select m from Member m left outer join m.team t";
//            String query = "select m from Member m, Team t where m.username = t.name";
//            String query = "select m from Member m left join m.team t on t.name = 'teamA'";
//
//            List<Member> result = em.createQuery(query,Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
            //타입
//            String query = "select m.username,'HELLO',true from Member m where m.type = jpql.MemberType.ADMIN";
//            List<Object[]> result = em.createQuery(query)
//                    .getResultList();
//            System.out.println("result.size = "+result.size());
//            for(Object[] objects : result){
//                System.out.println("objects = "+objects[0]);
//                System.out.println("objects = "+objects[1]);
//                System.out.println("objects = "+objects[2]);
//            }
            //기본 case 식
//            String query = "select case when m.age <= 10 then '학생요금' " +
//                                        "when m.age >= 60 then '경로요금' " +
//                                        "else '일반요금' end from Member m";
            //COALESCE
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m";
            //NULLIF
//            String query = "select nullif(m.username, '관리자') from Member m";
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for(String i : result){
//                System.out.println("result : "+i);
//            }
            //jpql 기본 함수
//            String query = "select locate('de', 'abcdefg') from Member m";
//
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for(String i : result){
//                System.out.println("result : "+i);
//            }
//            String query = "select m.team from Member m";
            //경로 표현식
//            String query = "select t.members from Team t";
//            Collection result = em.createQuery(query, Collection.class).getResultList();
//            for(Object s : result){
//                System.out.println("o = "+s);
//            }
            //명시적 조인을 통한 컬렉션 값 연관 경로의 탐색
//            String query = "select m.username from Team t join t.members m";
//            List<Collection> result = em.createQuery(query, Collection.class).getResultList();
//            System.out.println("result = "+result);
            //페치 조인 테스트
            //회원1, 팀A(SQL)  회원2, 팀A(1차캐시)  회원3, 팀B(SQL) 회원 100명 -> n+1 페치조인 미적용
//            String query = "select m from Member m";
//            String query = "select m from Member m join fetch m.team";
//            String query = "select t from Team t join fetch t.members";
//            String query = "select distinct t from Team t join fetch t.members";
//            List<Team> result = em.createQuery(query,Team.class)
//                    .getResultList();
//            for(Team team : result){
//                System.out.println("member = "+team.getName()+", members = "+team.getMembers().size());
//                for(Member member1 : team.getMembers()){
//                    System.out.println("-> member = "+member1.getUsername());
//                }
//            }
            //페치 조인 페이징 테스트
//            String query = "select t from Team t";
//            String query = "select m from Member m join fetch m.team";

//            List<Team> result = em.createQuery(query,Team.class).
//                    setFirstResult(0)
//                    .setMaxResults(2)
//                    .getResultList();
//            for(Team team : result){
//                System.out.println("member = "+team.getName()+", members = "+team.getMembers().size());
//                for(Member member1 : team.getMembers()){
//                    System.out.println("-> member = "+member1.getUsername());
//                }
//            }
            //엔티티 직접 사용
//            String query = "select m from Member m where m.id = :member";
//            Member findMember = em.createQuery(query,Member.class)
//                    .setParameter("member",member.getId())
//                    .getSingleResult();
//            System.out.println("findMember"+findMember);
            //named query
//            List<Member> resultList = em.createNamedQuery("Member.findByUsername",Member.class)
//                            .setParameter("username","회원1")
//                            .getResultList();
//            for (Member member1 : resultList) {
//                System.out.println("member="+member1);
//            }
            int resultCount = em.createQuery("update Member m set m.age = 20")
                            .executeUpdate();
            System.out.println("result = "+resultCount);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
