package dao.model;

/**
 * Created by Ирина on 04.05.2016.
 */
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String plase_time;
    private PersonDto person;

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPlase_time() {
        return plase_time;
    }

    public void setPlase_time(String plase_time) {
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
                '}';
    }
}