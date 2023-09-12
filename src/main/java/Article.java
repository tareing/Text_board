import java.time.LocalDateTime;

public class Article {
    // 게시물 번호
    private int id;
    private String title;
    // 내용
    private String content;

    private int views;






    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.views = 0;



    }


    public int getViews() {
        return views;
    }

    public void setViews() {
        views++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}