package jpabook.jpashop.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ExTeam {

    @Id @GeneratedValue
    @Column(name="TEAM_ID")
    private Long Id;

    @Column(name="NAME")
    private String name;

    //가짜 매핑. 읽기전용. 넣을때는 보지 않는다.
    @OneToMany(mappedBy = "team") //member Class의 team, team에 의해 관리가된다.
    @Column(name="MEMBERS")
    private List<ExMember> members = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExMember> getMembers() {
        return members;
    }

    public void setMembers(List<ExMember> members) {
        this.members = members;
    }

    public void addMember(ExMember member) {
        member.setTeam(this);
        members.add(member);
    }
}
