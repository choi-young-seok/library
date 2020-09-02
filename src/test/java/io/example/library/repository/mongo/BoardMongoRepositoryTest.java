package io.example.library.repository.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.example.library.domain.entity.board.Board;
import io.example.library.domain.entity.event.Event;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("BoardMongoRepository 테스트")
@Slf4j
class BoardMongoRepositoryTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MongoTemplate mongoTemplate;
//    @Autowired
//    BoardMongoRepository boardMongoRepository;

    @Test
    @DisplayName("단일 저장 테스트")

    private Board givenBoard() {
        Board board = Board.builder()
                .id(5)
                .title("게시글 제목")
                .content("게시글 내용")
                .author("최용석")
                .display(false)
//                .registerDateTime(LocalDateTime.now())
                .registerDateTime(new Date())
                .build();
        return board;
    }

    @Test
    public void saveOne_Mongo_Test() throws JsonProcessingException {
        Board board = givenBoard();
        log.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(board));

//        mongoTemplate.insert(board);
        mongoTemplate.insert(board, "board");
    }

    @Test
    public void log(){
        log.info("tt");
    }


}