package jpabook.jpashop.domain.dbexam;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class DBOrder {

    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    //관걔형 DB에 맞춘 설계..
    @Column(name="MEMBER_ID")
    private Long memberId;


    private LocalDateTime orderDate; //ORDER_DATE , order_date springboot 에서 기본이 언더스코어 소문자
    @Enumerated(EnumType.STRING)
    private DBOrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public DBOrderStatus getStatus() {
        return status;
    }

    public void setStatus(DBOrderStatus status) {
        this.status = status;
    }
}
