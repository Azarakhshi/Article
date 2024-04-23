package entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Article {

    private int id;

    private String title;

    private String brief;

    private String content;

    private String createDate;

    private boolean isPublished;

    private int userId;

}
