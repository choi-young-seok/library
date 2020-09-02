package io.example.library.domain.dto;

import io.example.library.domain.entity.event.Event;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

//import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.methodOn;


/**
 * SpringBoot 및 HATEOAS 버전 업그레이드에 따른 클래스명 변경
 *  - ResourceSupport changed to RepresentationModel
 *  - Resource changed to EntityModel
 *  - Resources changed to CollectionModel
 *  - PagedResources changed to PagedModel
 *  - ResourceAssembler changed to RepresentationModelAssembler
 * official docs URL : https://docs.spring.io/spring-hateoas/docs/current/reference/html/
 * 참고 URL : https://stackoverflow.com/questions/25352764/hateoas-methods-not-found
 * */

/**
 * {@link EventRepresentationModel} Class의 코드량을 줄이기 위한 Refactor Class
 * {@link org.springframework.hateoas.RepresentationModel}내부에
 * @JsonUnwrapped가 이미 적용되어 구현된 EntityModel<T> Method를 이용하여 개발자가 코드로 명시하지 않고
 * 코드를 줄이면서 같은효과를 얻는다.
 * */
public class EventEntityModel extends EntityModel<Event> {

    public EventEntityModel(Event event, Link... links) {
        super(event, links);

        /**
         * String으로 Url을 명시하는 경우 Controller 혹은 method의 mapping정보가 변경될 경우 typeSafe하지 않으므로
         * Spring HATEOAS의 linkto()를 사용하여 mapping정보 변경에도 typeSafe하게 작성
         * */
//        add(new Link("http://localhost:8080/api/event/" + event.getId()).withSelfRel();
//        add(linkTo(methodOn(EventController.class)).withSelfRel());
    }
}
