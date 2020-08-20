package jpabook.jpashop.domain.joinstrategy;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JoinMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            JoinMovie movie = new JoinMovie();
            movie.setDirector("aaaaa");
            movie.setActor("bbbbb");
            movie.setName("바람과함께");
            movie.setPrice(123123);

            em.persist(movie);

            em.flush();
            em.clear();

            JoinMovie joinMovie = em.find(JoinMovie.class, movie.getId());
            System.out.println(joinMovie);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
