package jpabook.jpashop.domain.joinstrategy;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class JoinAlbum extends JoinItem{
    private String artist;
}
