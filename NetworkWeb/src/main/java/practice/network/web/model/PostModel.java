package practice.network.web.model;

/**
 * Created by Ирина on 12.06.2016.
 */
public class PostModel {

    private String title;
    private String content;

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

    @Override
    public String toString() {
        return "PostModel{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
