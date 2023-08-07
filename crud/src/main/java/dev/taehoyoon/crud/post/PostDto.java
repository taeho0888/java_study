package dev.taehoyoon.crud.post;

public class PostDto { // Data Transfer Object 데이터를 주고받는 데에 사용되는 객체다! 라는 뜻
    private String title;
    private String content;
    private String writer;

    // 생성자, getter, setter, toString 다 쓰기 귀찮으면 Lombok 같은 라이브러리 사용할 수 있
    public PostDto(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
