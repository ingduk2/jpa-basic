package jpabook.jpashop.example.embedded;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class EmJpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            EmMember member = new EmMember();
            member.setUsername("member1");
            member.setAddress(new EmAddress("cirty1", "address", "zip"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity(new EmAddress("old11", "address", "zip")));
            member.getAddressHistory().add(new AddressEntity(new EmAddress("old22", "address", "zip")));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("=======start=============");
            EmMember findMember = em.find(EmMember.class, member.getId());

//            List<EmAddress> addressHistory = findMember.getAddressHistory();
//            for (EmAddress address : addressHistory) {
//                System.out.println("fav address : " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("fav fooe : " + favoriteFood);
//            }

            EmAddress a = findMember.getAddress();
            findMember.setAddress(new EmAddress("newCity", a.getStreet(), a.getZipcode()));

            //치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

//            findMember.getAddressHistory().remove(new AddressEntity(new EmAddress("old11", "address", "zip")));
//            findMember.getAddressHistory().add(new AddressEntity(new EmAddress("newCity1", "address", "zip")));
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();

    }


}
