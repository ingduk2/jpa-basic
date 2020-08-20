package jpabook.jpashop.domain.joinstrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class JoinBook extends JoinItem{
    private String author;
    private String isbn;
}
