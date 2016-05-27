package dao.entities;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;

/**
 * Created by Ирина on 22.04.2016.
 */
@Entity
@Table(name = "PERSON")
public class Person implements HasID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "FIRST_NAME")
    private String firstNname;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;
    @Column(name = "NICKNAME")
    private String nicName;
  /*  @ManyToMany
    @JoinTable(
            name = "FRIENDSHIP",
            inverseJoinColumns = @JoinColumn(name ="PERSON_ID" ),
            joinColumns = @JoinColumn(name = "FRIEND_ID")
    )*/
   // private  Set<Person> friends;
   /* @Transient
    @ManyToMany(mappedBy ="friends" )
    private Set<Person> personfriend;*/
   /* @Transient
    @OneToMany(mappedBy = "personFrom")
    private Set<Message> messageSetFrom;
    @Transient
    @OneToMany(mappedBy = "personTo")
    private Set<Message> messageSetTo;
*/
 /*   @OneToMany(mappedBy = "person")
    private Set<Post> postSet;*/
/*    @ManyToMany(mappedBy ="persons" )
    private Set<Post> postLikesSet;*/







    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id=id;

    }


    public String getFirstNname() {
        return firstNname;
    }

    public void setFirstNname(String firstNname) {
        this.firstNname = firstNname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getNicName() {
        return nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id == person.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstNname='" + firstNname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", nicName='" + nicName + '\'' +
                '}';
    }
}
