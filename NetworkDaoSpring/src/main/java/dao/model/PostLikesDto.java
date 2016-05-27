package dao.model;

/**
 * Created by Ирина on 04.05.2016.
 */
public class PostLikesDto {
    private PostDto postId;
    private PersonDto personId;

    public PostDto getPostId() {
        return postId;
    }

    public void setPostId(PostDto postId) {
        this.postId = postId;
    }

    public PersonDto getPersonId() {
        return personId;
    }

    public void setPersonId(PersonDto personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostLikesDto that = (PostLikesDto) o;

        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        return !(personId != null ? !personId.equals(that.personId) : that.personId != null);

    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PostLikesDto{" +
                "postId=" + postId.getId() +
                ", personId=" + personId.getId() +
                '}';
    }
}