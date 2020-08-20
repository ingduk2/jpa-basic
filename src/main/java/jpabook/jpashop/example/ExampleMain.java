package jpabook.jpashop.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ExampleMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            ExTeam team = new ExTeam();
            team.setName("TeamA");
            em.persist(team);

            ExMember member = new ExMember();
            member.setUsername("member1");
            member.changeTeam(team); //** 연관관계 편의 메서드.
            em.persist(member);

            team.addMember(member); // 연관관계 편의 메서드 위와 둘중에 하나를 정하면 된다. 두개다 하면 꼬인다.

            //객체 지향적으로는 양쪽으로 값을 넣어주는 것이 맞다.
            //setTeam 에 넣어버리자. 편의 메소드
//            team.getMembers().add(member); //**

//            em.flush();
//            em.clear();

            ExTeam findTeam = em.find(ExTeam.class, team.getId()); // 1차 캐시
            List<ExMember> members = findTeam.getMembers();

            //flush clear 안하면 값이 없다.
            System.out.println("=========");
            for (ExMember exMember : members) {
                System.out.println("------" + exMember.getUsername());
            }
            System.out.println("=========");

            tx.commit();

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
