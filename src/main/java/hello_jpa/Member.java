package hello_jpa;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
//@TableGenerator(
//        name = "member_seq_generator",
//        table = "my_sequences",
//        pkColumnValue = "member_seq", allocationSize = 1
//)
@SequenceGenerator(
        name = "member_seq_generator",
        sequenceName = "member_seq",
        initialValue = 1, allocationSize = 50
)
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "username")
    private String username;
//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();
//
//    @OneToOne
//    @JoinColumn(name="LOCKER_ID")
//    private Locker locker;

    //기간 period
    @Embedded
    private Period workPeriod;
    //주소 address
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
        @JoinColumn(name = "MEMBER_ID")
    )
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();
    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns =
        @JoinColumn(name = "MEMBER_ID")
    )
    private List<Address> addressHistory = new ArrayList<>();
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name="city",
//                column=@Column(name = "WORK_CITY")),
//            @AttributeOverride(name="street",
//                column = @Column(name="WORK_STREET")),
//            @AttributeOverride(name="zipcode",
//                column = @Column(name = "WORK_ZIPCODE"))
//    })
//    private Address workAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Team team;

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<Address> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<Address> addressHistory) {
        this.addressHistory = addressHistory;
    }

//    @Column(name = "team_id")
//    private Long teamid;
//    private Integer age;
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    //자바에서는 날짜, 날짜/시간을 구분없이 쓰지만
//    // 데이터 베이스에서는 모두 다르게 쓰기 때문에 Date, time,timestamp를 모두 구분해서 써야한다.
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//    @Lob
//    private String description;

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getTeamid() {
//        return teamid;
//    }
//
//    public void setTeamid(Long teamid) {
//        this.teamid = teamid;
//    }

//    public Team getTeam() {
//        return team;
//    }
//
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }

//    public void setTeam(Team team) {
//        this.team = team;
//    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    //
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(RoleType roleType) {
//        this.roleType = roleType;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public Date getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

    Member(){
    }

}
