package io.example.library.util.domain.event;

import io.example.library.domain.dto.EventDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component //Bean으로 등록
@Slf4j
public class EventDtoValidator {

    /*입력값 EventDto에 대한 값 검증,
    * 해당 객체 검증 과정에서 오류 발생 시 Errors객체에 오류 내용을 담는다. */
    public void validate(EventDto eventDto, Errors errors){
        int basePrice = eventDto.getBasePrice();
        int maxPrice = eventDto.getMaxPrice();

        /* 금액 유효성 검사 : 기본금액이 최대금액보다 크고, 최대 금액이 0이 아닌 경우 */
        if(basePrice > maxPrice && maxPrice != 0){
            errors.rejectValue("basePrice", "wrongValue", "basePrice is wrong");
            errors.rejectValue("maxPrice", "wrongValue", "maxPrice is wrong");
        }

        LocalDateTime beginEnrollmentDateTime = eventDto.getBeginEnrollmentDateTime();
        LocalDateTime closeEnrollmentDateTime = eventDto.getCloseEnrollmentDateTime();
        LocalDateTime beginEventDateTime = eventDto.getBeginEventDateTime();
        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();

        /* 등록 시작일 유효성 검사 : 등록 시작 일자가 등록 마감일, 시작일, 종료일 보다 늦은 경우 */
        if(beginEnrollmentDateTime.isAfter(closeEnrollmentDateTime)
                || beginEnrollmentDateTime.isAfter(beginEventDateTime)
                || endEventDateTime.isAfter(endEventDateTime)
        ){
            errors.rejectValue("beginEnrollmentDateTime", "wrongValue", "beginEnrollmentDateTime is wrong");
        }

        /* 등록 마감일 날짜 유효성 검사 : 등록 마감 일자가 시작일, 종료일 보다 늦은 경우 */
        if(closeEnrollmentDateTime.isAfter(beginEventDateTime)
                || closeEnrollmentDateTime.isAfter(endEventDateTime)
        ){
            errors.rejectValue("closeEnrollmentDateTime", "WrongValue", "closeEnrollmentDateTime is wrong");
        }

        /* 이벤트 시작일 날짜 유효성 검사 : 시작 일자가 등록 시작일, 등록 마감일 보다 빠르거나, 종료일 보다 늦은 경우 */
        if(beginEventDateTime.isBefore(beginEnrollmentDateTime)
                || endEventDateTime.isBefore(closeEnrollmentDateTime)
                || beginEventDateTime.isAfter(endEventDateTime)
        ){
            errors.rejectValue("beginEventDateTime", "WrongValue", "beginEventDateTime is wrong");
        }
    }

}
