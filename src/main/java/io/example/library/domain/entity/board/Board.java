package io.example.library.domain.entity.board;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@Document(collection = "board")
public class Board {

    private int id;

    private String title;

    private String content;

    private String author;

    private boolean display;

    private Date registerDateTime;

    @Builder
    public Board(int id, String title, String content, String author, boolean display, Date registerDateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.display = display;
        this.registerDateTime = registerDateTime;
    }

    //    private LocalDateTime updateDateTime;


}
