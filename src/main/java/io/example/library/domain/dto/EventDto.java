package io.example.library.domain.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "{id}")
@ToString
// 입력값을 제한하기 위해 파라미터로 수신할 객체
public class EventDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotNull
    private LocalDateTime beginEnrollmentDateTime;

    @NotNull
    private LocalDateTime closeEnrollmentDateTime;

    @NotNull
    private LocalDateTime beginEventDateTime;

    @NotNull
    private LocalDateTime endEventDateTime;

    private String location; // (optional) 온라인/오프라인 구분 필드

    @Min(0)
    private int basePrice; // (optional)

    @Min(0)
    private int maxPrice; // (optional)

    @Min(0)
    private int limitOfEnrollment;
}
