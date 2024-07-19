package hello_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성 (db연결) db당 하나만 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //엔티티 매니저 생성 > 고객의 요청이 있을때마다 생성하고 요청이 끝나면 삭제 반복 스레드간 공유 절대 금지
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{
            //insert
            //준영속상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속상태
//            em.persist(member);



            //select
//            Member findMember = em.find(Member.class,1L);
//            System.out.println(findMember.getId()+" : "+findMember.getName());
//
//            //update
//            findMember.setName("helloB");
//
//            //delete
//            em.remove(findMember);

            //JPQL > 객체지향 쿼리
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)//페이징에 유리하다.
//                    .setMaxResults(10)
//                    .getResultList();

            //1차 캐시 테스트
//            Member findMember2 = em.find(Member.class,101L);
//            Member findMember3 = em.find(Member.class,101L);
//
//            System.out.println("findMember = "+ (findMember3==findMember2));
//
//            Member member2 = new Member(150L,"A");
//            Member member3 = new Member(160L,"B");
//            em.persist(member2);
//            em.persist(member3);
//            System.out.println("-=========================");
//            Member member4 = em.find(Member.class,160L);
//            member4.setName("faker");
//            Member member4 = em.find(Member.class,160L);
////            em.detach(member4);
//            em.clear();
//            Member member5 = em.find(Member.class,160L);
            //EnumType.ORDINAL 테스트
//            Member member = new Member();
//            member.setId(3L);
//            member.setUsername("B");
//            member.setRoleType(RoleType.admin);
//            em.persist(member);
            //GeneratedValue 테스트
//            Member member = new Member();
//
//            member.setUsername("B");
//
//            em.persist(member);
            //identity insert 테스트
//            Member member = new Member();
//            member.setUsername("C");
//            System.out.println("******");
//            em.persist(member);
//            System.out.println("******");
            //allocationSize
//            Member member1 = new Member();
//            member1.setUsername("A");
//            Member member2 = new Member();
//            member2.setUsername("B");
//            Member member3 = new Member();
//            member3.setUsername("C");
//            System.out.println("******");
//            em.persist(member1);
//            em.persist(member2);
//            em.persist(member3);
//            System.out.println("member1 = "+member1.getId());
//            System.out.println("member2 = "+member2.getId());
//            System.out.println("member3 = "+member3.getId());
//            System.out.println("******");

            //단반향 연관관계 테스트
//            Team team = new Team();
//            team.setName("TeamA");
//
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//            em.flush();
//            em.clear();

            //양방향 연관관계에서 자주 하는 실수 > mappedBy로 매핑된 테이블은 상대 테이블에 값을 추가해야 한다.
//            Team team = new Team();
//            team.setName("TeamA");
//
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.changeTeam(team);
//            em.persist(member);
//            em.flush();
//            em.clear();
//            Member findMember = em.find(Member.class,member.getId());
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam ="+findTeam.getName());
//
//            Team newTeam = em.find(Team.class,100L);
//            findMember.setTeam(newTeam);

//            Member findMember2 = em.find(Member.class,member.getId());
//            List<Member> members = findMember2.getTeam().getMembers();
//            for(Member m : members){
//                System.out.println("m = "+m.getUsername());
//            }

            //1:N 단방향(1이 주인) 일때 테스트
//            Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            em.persist(team);
            //슈퍼/서브 상속관계 매핑 전략 테스트
//            Movie movie = new Movie();
//            movie.setDirector("a");
//            movie.setActor("bbb");
//            movie.setName("Notebook");
//            movie.setPrice(10000);
//            em.persist(movie);
//            em.flush();
//            em.clear();
//            Movie findMove = em.find(Movie.class,movie.getId());
//
//            em.clear();
//            Item item = em.find(Movie.class,movie.getId());
//            System.out.println("findmovie:"+findMove);

//            System.out.println("item:"+item);

            //@MappedSuperClass 테스트
//            Member member = new Member();
//            member.setUsername("user1");
//            member.setCreatedBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//            em.persist(member);
//            em.flush();
//            em.clear();

            //프록시 테스트

//            Member member = new Member();
//            member.setUsername("hello");
//
//            em.persist(member);
//            em.flush();
//            em.clear();
//
////            Member findMember = em.find(Member.class,member.getId());
//            Member findMember = em.getReference(Member.class,member.getId());
//            System.out.println(findMember.getId());
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Team teamB = new Team();
//            team.setName("teamB");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setTeam(teamB);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();

//            Member m = em.find(Member.class,member1.getId());
//            List<Member> members = em.createQuery("select m from Member m",  Member.class).getResultList();
//            System.out.println("m = "+m.getTeam().getClass());
//            System.out.println("===");
//            m.getTeam().getName();
//            System.out.println("===");
            //cascade 테스트
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
////            em.persist(child1);
////            em.persist(child2);
//            em.flush();;
//            em.clear();
//            Parent findParent = em.find(Parent.class,parent.getId());
//            findParent.getChildList().remove(0);
//            em.remove(findParent);

            //임베디드 타입 테스트
//            Address address = new Address("city","street","zipcode");
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
////            member.setWorkPeriod(new Period());
//            Address copyAddress = new Address(address.getCity(),address.getStreet(), address.getZipcode());
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);
//            member.getHomeAddress().setCity("newCity");
            //
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(new Address("homeCity","street","zipcode"));
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("햄버거");
//            member.getAddressHistory().add(new Address("old1","street","zipcode"));
//            member.getAddressHistory().add(new Address("old2","street","zipcode"));
//            em.persist(member);
//            em.flush();
//            em.clear();
//            System.out.println("===");
//            Member findMember = em.find(Member.class,member.getId());
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(),a.getZipcode()));
//            //String 이기 때문에 수정하는게 아닌 삭제후 추가 해야함
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");
//
//            findMember.getAddressHistory().remove(new Address("old1","street","zipcode"));
//            findMember.getAddressHistory().add(new Address("new1","street","zipcode"));
            //JPQL
//            List<Member> result = em.createQuery(
//                    "select m from Member m where m.username like '%kim%'",
//                    Member.class
//            ).getResultList();
//            for(Member member : result){
//                System.out.println("member = "+member);
//            }
            //Criteria
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);
            Root<Member> m = query.from(Member.class);
            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"),"kim"));
            List<Member> resultList = em.createQuery(cq).getResultList();
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
