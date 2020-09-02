//package io.example.library.repository.mongo;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.example.library.domain.dto.EventDto;
//import io.example.library.domain.entity.event.Event;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@DisplayName("EventMongoRepository 테스트")
//@Slf4j
//class EventMongoRepositoryTest {
//
//    @Autowired
//    EventMongoRepository eventMongoRepository;
//
//    @Autowired
//    ModelMapper modelMapper;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    private Event GivenEvent(EventDto eventDto) {
//        Event event = modelMapper.map(eventDto, Event.class);
//        event.update();
//        return event;
//    }
//
//    private EventDto GivenEventDto() {
//        EventDto eventDto = EventDto.builder()
//                .name("sample event name")
//                .description("sample event description")
//                .beginEnrollmentDateTime(LocalDateTime.of(2020, 8, 06, 9, 30 ))
//                .closeEnrollmentDateTime(LocalDateTime.of(2020, 8, 07, 9, 30 ))
//                .beginEventDateTime(LocalDateTime.of(2020, 8, 13, 19, 00))
//                .endEventDateTime(LocalDateTime.of(2020, 8, 13, 22, 00))
//                .basePrice(100)
//                .maxPrice(200)
//                .limitOfEnrollment(0)
//                .location("sample location")
//                .build();
//        return eventDto;
//    }
//
//    @Test
//    @DisplayName("단일 저장 테스트")
//    public void saveOne_Mongo_Test() throws JsonProcessingException {
//        Event event = GivenEvent(GivenEventDto());
//        event.setId(33385525);
//        log.info("given param : {}, ",objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(event));
//
//        Event createdEvent = eventMongoRepository.insert(event);
//        log.info("then insert : {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createdEvent));
//
//        assertThat(event.equals(createdEvent));
//    }
//
//    @Test
//    @DisplayName("목록 저장 테스트")
//    public void saveAll_Mongo_Test(){
//
//    }
//
//    @Test
//    @DisplayName("단일 조회 테스트")
//    public void seleteOne_Mongo_Test(){
//
//    }
//
//    @Test
//    @DisplayName("목록 조회 테스트")
//    public void seleteAll_Mongo_Test(){
//
//    }
//
//    @Test
//    @DisplayName("단일 수정 테스트")
//    public void updateOne_Mongo_Test(){
//
//    }
//
//    @Test
//    @DisplayName("목록 수정 테스트")
//    public void updateAll_Mongo_Test(){
//
//    }
//
//    @Test
//    @DisplayName("단일 삭제 테스트")
//    public  void deleteOne_Mongo_Test(){
//
//    }
//
//    @Test
//    @DisplayName("목록 삭제 테스트")
//    public  void deleteAll_Mongo_Test(){
//
//    }
//
//}