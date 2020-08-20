package jpabook.jpashop.example.embedded;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;
    private EmAddress address;


    public AddressEntity() {
    }

    public AddressEntity(EmAddress address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmAddress getAddress() {
        return address;
    }

    public void setAddress(EmAddress address) {
        this.address = address;
    }
}
