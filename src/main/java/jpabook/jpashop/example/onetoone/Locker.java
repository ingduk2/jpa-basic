package jpabook.jpashop.example.onetoone;

import jpabook.jpashop.example.ExMember;

import javax.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker" , fetch = FetchType.LAZY)
    private ExMember member;
}
