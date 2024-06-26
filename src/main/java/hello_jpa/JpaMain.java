package hello_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
//            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
