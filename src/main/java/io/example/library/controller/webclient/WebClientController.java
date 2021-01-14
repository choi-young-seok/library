package io.example.library.controller.webclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/example/webclient")
@RequiredArgsConstructor
@Slf4j
public class WebClientController {

    @GetMapping("/publish")
    public String publisher(){
        String pubData = "hello webclient";
        return pubData;
    }


    /** need spring webflux dependency
     *         <dependency>
     *             <groupId>org.springframework.boot</groupId>
     *             <artifactId>spring-boot-starter-webflux</artifactId>
     *         </dependency>
     */
    private final WebClient.Builder webClientBuilder;

    @GetMapping("/subscribe")
    public void subscriber(){

        WebClient webClient = this.webClientBuilder
                .baseUrl("http://localhost:8080/example/webclient")
                .build();

        Mono<String> callResult = webClient.get()
                .uri("/publish")
                .retrieve()
                .bodyToMono(String.class)
        ;

        callResult.subscribe(string ->{
            log.info(string);
        });

    }
}
