package hello_jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long teamId;
    @Column(name = "NAME")
    private String name;
    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();

//    public void addMember(Member member){
//        member.setTeam(this);
//        members.add(member);
//    }
    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

//    @OneToMany(mappedBy = "team")//조인된 상대 테이블의 컬럼명


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }


}
