package dao.entities;

import javax.persistence.*;

/**
 * Created by Ирина on 22.04.2016.
 */
@Entity
@Table(name = "POST_LIKES")
public class PostLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post postId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person personId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostLikes postLikes = (PostLikes) o;

        if (postId != null ? !postId.equals(postLikes.postId) : postLikes.postId != null) return false;
        return !(personId != null ? !personId.equals(postLikes.personId) : postLikes.personId != null);

    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PostLikes{" +
                "postId=" + postId.getId() +
                ", personId=" + personId.getId() +
                '}';
    }
}
