package uno.dos.tres.bean;

import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String content;
    private String imgPath;

    public News() {}

    public News(String title, String content, String imgPath) {
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(title, news.title) && Objects.equals(content, news.content) && Objects.equals(imgPath, news.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, imgPath);
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
