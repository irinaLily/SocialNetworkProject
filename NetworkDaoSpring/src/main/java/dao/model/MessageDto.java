package dao.model;

import java.time.LocalDate;

/**
 * Created by Ирина on 04.05.2016.
 */
public class MessageDto {
    private Long id;
    private String content;
    private LocalDate timeSent;
    private PersonDto personFrom;
    private PersonDto personTo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(LocalDate timeSent) {
        this.timeSent = timeSent;
    }

    public PersonDto getPersonFrom() {
        return personFrom;
    }

    public void setPersonFrom(PersonDto personFrom) {
        this.personFrom = personFrom;
    }

    public PersonDto getPersonTo() {
        return personTo;
    }

    public void setPersonTo(PersonDto personTo) {
        this.personTo = personTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageDto that = (MessageDto) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (timeSent != null ? !timeSent.equals(that.timeSent) : that.timeSent != null) return false;
        if (personFrom != null ? !personFrom.equals(that.personFrom) : that.personFrom != null) return false;
        return !(personTo != null ? !personTo.equals(that.personTo) : that.personTo != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (timeSent != null ? timeSent.hashCode() : 0);
        result = 31 * result + (personFrom != null ? personFrom.hashCode() : 0);
        result = 31 * result + (personTo != null ? personTo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timeSent=" + timeSent +
                ", personFrom=" + personFrom.getId() +
                ", personTo=" + personTo.getId() +
                '}';
    }
}