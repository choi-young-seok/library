package io.example.library.domain.entity.event;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Slf4j
public class Event {

    //SpringBoot 2.1 부터는 JPA 3.2를 지원
    // - JPA 3.2는 LocalDateTime Mapping 가능
    //Enum class는 @Enumerated annotaion으로 mapping
    // - @Enumerated의 EnumType은 default ORDINARY로 Enum에 선언된 값의 순서에 따라 0, 1, 2의 값이 순차적으로 설정되는데,
    // Enum에 선언된 값의 순서가 변경 될 경우, 설정된 값이 일치 하지 않으므로,
    // 순서 변경과 상관없이 값을 보장 할수 있도록 EnumType.String으로 설정한다.
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location; // (optional) 온라인/오프라인 구분 필드
    private int basePrice; // (optional)
    private int maxPrice; // (optional)
    private int limitOfEnrollment;
    private boolean offline;

    //default value로 DRAFT를 지정
    private boolean free;
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus = EventStatus.DRAFT;

    public void update() {
        // basePrice / maxPrice 항목의 입력 값에 따른 free 항목 설정
        if(this.basePrice == 0 && this.maxPrice == 0){
            this.free = true;
        }else{
            this.free = false;
        }

        // java 8
        if(this.location == null || this.location.trim().isEmpty()){
            this.offline = false;
        }else{
            this.offline = true;
        }

//        // java 11
//        if(this.location == null || this.location.isBlank()){
//            this.offline = false;
//        }else{
//            this.offline = true;
//        }
    }
}
