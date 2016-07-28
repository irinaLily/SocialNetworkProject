package dao.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Ирина on 04.05.2016.
 */
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private LocalDate plase_time;
    private PersonDto person;
    private List<PersonDto> postLikesPerson;

    public List<PersonDto> getPostLikesPerson() {
        return postLikesPerson;
    }

    public void setPostLikesPerson(List<PersonDto> postLikesPerson) {
        this.postLikesPerson = postLikesPerson;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPlase_time() {
        return plase_time;
    }

    public void setPlase_time(LocalDate plase_time) {
        this.plase_time = plase_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostDto postDto = (PostDto) o;

        if (id != postDto.id) return false;
        if (title != null ? !title.equals(postDto.title) : postDto.title != null) return false;
        if (content != null ? !content.equals(postDto.content) : postDto.content != null) return false;
        if (plase_time != null ? !plase_time.equals(postDto.plase_time) : postDto.plase_time != null) return false;
        return !(person != null ? !person.equals(postDto.person) : postDto.person != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (plase_time != null ? plase_time.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", plase_time='" + plase_time + '\'' +
                ", person=" + person.getId() +
                ",likes Nik"+ postLikesPerson+
                '}';
    }
}