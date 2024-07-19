package jpql;



import javax.persistence.*;
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
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

//            TypedQuery<Member> query1 = em.createQuery("select m from Member m",Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m",String.class);
//            Query query3 = em.createQuery("select m.age, m.username from Member m");
//            List<Member> resultList = query1.getResultList();
//            for(Member member1 : resultList){
//                System.out.println(member1);
//            }
            TypedQuery<Member> query1 = em.createQuery("select m from Member m where m.username=:username",Member.class);
            query1.setParameter("username","kim");

            TypedQuery<Member> query2 = em.createQuery("select m from Member m where m.username=?1",Member.class);
            query2.setParameter(1,"kim");

            Member result = query1.getSingleResult();
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
