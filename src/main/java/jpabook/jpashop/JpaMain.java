package jpabook.jpashop;

import hello_jpa.BaseEntity;
import hello_jpa.Member;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성 (db연결) db당 하나만 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //엔티티 매니저 생성 > 고객의 요청이 있을때마다 생성하고 요청이 끝나면 삭제 반복 스레드간 공유 절대 금지
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("kim");
            em.persist(book);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
