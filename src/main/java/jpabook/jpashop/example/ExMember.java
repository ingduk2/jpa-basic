package jpabook.jpashop.example;

import jpabook.jpashop.example.onetoone.Locker;

import javax.persistence.*;

@Entity
public class ExMember {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

//    @Column(name="TEAM_ID")
//    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "TEAM_ID")
    private ExTeam team;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

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

    public ExTeam getTeam() {
        return team;
    }

    public void setTeam(ExTeam team) {
        this.team = team;
    }

    public void changeTeam(ExTeam team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
