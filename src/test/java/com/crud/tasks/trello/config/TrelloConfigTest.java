package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TrelloConfigTest {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    void givenTrelloData() {
        //Given & When
        URI url = UriComponentsBuilder
                .fromHttpUrl(trelloConfig.getTrelloApiEndpoint() + "/members/" + trelloConfig.getTrelloUsername() + "/boards")
                .queryParam("key", trelloConfig.getTrelloAppKey())
                .queryParam("token", trelloConfig.getTrelloToken())
                .queryParam("fields", "name,id")
                .queryParam("lists", "all")
                .build()
                .encode()
                .toUri();

        URI url2 = UriComponentsBuilder
                .fromHttpUrl("https://api.trello.com/1" + "/members/" + "beetls" + "/boards")
                .queryParam("key", "a4420aaa869aff9d4dc24c166d61f109")
                .queryParam("token", "ATTA77676ae9c4fa14b11751b9f63fb5fcf91a7de4d159f7eef124ad667a0fbf3bbd686F542D")
                .queryParam("fields", "name,id")
                .queryParam("lists", "all")
                .build()
                .encode()
                .toUri();

        //Then
        assertEquals(url, url2);
    }
}

