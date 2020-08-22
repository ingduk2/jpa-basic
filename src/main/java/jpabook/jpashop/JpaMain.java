package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.example.ExMember;
import jpabook.jpashop.example.ExTeam;
import jpabook.jpashop.example.cascade.Child;
import jpabook.jpashop.example.cascade.Parent;
import jpabook.jpashop.example.embedded.EmAddress;
import jpabook.jpashop.example.embedded.EmMember;
import org.hibernate.internal.EntityManagerMessageLogger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.ws.soap.Addressing;
import java.util.List;
import java.util.NoSuchElementException;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            EmMember member = new EmMember();
            member.setUsername("asdf");
            member.setAddress(new EmAddress("a" , "b" , "c"));

            em.persist(member);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();

    }


}
