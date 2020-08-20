package jpabook.jpashop.example.embedded;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class EmMember {

    @Id
    @GeneratedValue
    private Long id;

    private String username;


    @Embedded
    private EmPeriod period;

    @Embedded
    private EmAddress address;

    @ElementCollection
    @CollectionTable(name="FAVORITE_FOOD", joinColumns =
        @JoinColumn(name = "MEMBER_ID"))
    @Column(name="FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    //값타입 컬렉션이므로 다지워지고 다 저장되는 문제 발생. 기준을 알수 없음
//    @ElementCollection
//    @CollectionTable(name="EMADDRESS", joinColumns =
//        @JoinColumn(name = "MEMBER_ID"))
//    private List<EmAddress> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
//            @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
//            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
//    })
//    private EmAddress homeAddress;


    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EmPeriod getPeriod() {
        return period;
    }

    public void setPeriod(EmPeriod period) {
        this.period = period;
    }

    public EmAddress getAddress() {
        return address;
    }

    public void setAddress(EmAddress address) {
        this.address = address;
    }
}
