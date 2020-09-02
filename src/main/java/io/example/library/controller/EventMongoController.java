package io.example.library.controller;

import io.example.library.domain.dto.EventDto;
import io.example.library.domain.dto.EventEntityModel;
import io.example.library.domain.entity.event.Event;
import io.example.library.util.common.ErrorEntityModel;
import io.example.library.util.domain.event.EventDtoValidator;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/mongo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaTypes.HAL_JSON_VALUE)
public class EventMongoController {

    private final ModelMapper modelMapper;
    private final EventDtoValidator eventDtoValidator;

    public EventMongoController(ModelMapper modelMapper, EventDtoValidator eventDtoValidator) {
        this.modelMapper = modelMapper;
        this.eventDtoValidator = eventDtoValidator;
    }

    @PostMapping
    public ResponseEntity createEventMongo(@RequestBody @Valid EventDto eventDto, Errors errors){
        if(errors.hasErrors()){
            return badReqeust(errors);
        }

        eventDtoValidator.validate(eventDto, errors);
        if(errors.hasErrors()){
            return badReqeust(errors);
        }

        Event event = modelMapper.map(eventDto, Event.class);
        event.update();
        Event createdEvent = null;

        WebMvcLinkBuilder selfLinkBuilder = linkTo(methodOn(EventMongoController.class).createEventMongo(eventDto, errors));
        URI createdUri = selfLinkBuilder.toUri();

        EventEntityModel eventEntityModel = new EventEntityModel(event);
        eventEntityModel.add(selfLinkBuilder.slash(createdEvent.getId()).withRel("query-event"));
        eventEntityModel.add(selfLinkBuilder.slash(createdEvent.getId()).withRel("update-event"));
        eventEntityModel.add(new Link("/docs/index.html#resources-events-create").withRel("profile"));

        URI createdUril = linkTo(EventController.class).toUri();
        return ResponseEntity.created(createdUril).build();
    }

    @GetMapping
    public ResponseEntity getEventMongo(){

        return null;
    }

//    @GetMapping
//    public ResponseEntity queryEventMongo(){
//
//        return null;
//    }

    @PutMapping
    public ResponseEntity updateEventMongo(){

        return null;
    }

    @DeleteMapping
    public ResponseEntity deleteEventMongo(){

        return null;
    }

    private ResponseEntity badReqeust(Errors errors) {
        return ResponseEntity.badRequest().body(new ErrorEntityModel(errors));
    }
}
