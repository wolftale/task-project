package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void shouldMapToBoards() {
        // Given
        List<TrelloBoardDto> trelloBoardDtoList = Arrays.asList(
                new TrelloBoardDto("board1", "Board 1", Arrays.asList(
                        new TrelloListDto("list1", "List 1", false),
                        new TrelloListDto("list2", "List 2", true)
                )),
                new TrelloBoardDto("board2", "Board 2", Arrays.asList(
                        new TrelloListDto("list3", "List 3", false),
                        new TrelloListDto("list4", "List 4", true)
                ))
        );

        // When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);

        // Then
        assertEquals(trelloBoardDtoList.size(), trelloBoardList.size());
        for (int i = 0; i < trelloBoardDtoList.size(); i++) {
            TrelloBoardDto trelloBoardDto = trelloBoardDtoList.get(i);
            TrelloBoard trelloBoard = trelloBoardList.get(i);
            assertEquals(trelloBoardDto.getId(), trelloBoard.getId());
            assertEquals(trelloBoardDto.getName(), trelloBoard.getName());
            assertEquals(trelloBoardDto.getLists().size(), trelloBoard.getLists().size());
            for (int j = 0; j < trelloBoardDto.getLists().size(); j++) {
                TrelloListDto trelloListDto = trelloBoardDto.getLists().get(j);
                TrelloList trelloList = trelloBoard.getLists().get(j);
                assertEquals(trelloListDto.getId(), trelloList.getId());
                assertEquals(trelloListDto.getName(), trelloList.getName());
                assertEquals(trelloListDto.isClosed(), trelloList.isClosed());
            }
        }
    }

    @Test
    public void shouldMapToBoardsDto() {
        // Given
        List<TrelloBoard> trelloBoardList = Arrays.asList(
                new TrelloBoard("board1", "Board 1", Arrays.asList(
                        new TrelloList("list1", "List 1", false),
                        new TrelloList("list2", "List 2", true)
                )),
                new TrelloBoard("board2", "Board 2", Arrays.asList(
                        new TrelloList("list3", "List 3", false),
                        new TrelloList("list4", "List 4", true)
                ))
        );

        // When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        // Then
        assertEquals(trelloBoardList.size(), trelloBoardDtoList.size());
        for (int i = 0; i < trelloBoardList.size(); i++) {
            TrelloBoard trelloBoard = trelloBoardList.get(i);
            TrelloBoardDto trelloBoardDto = trelloBoardDtoList.get(i);
            assertEquals(trelloBoard.getId(), trelloBoardDto.getId());
            assertEquals(trelloBoard.getName(), trelloBoardDto.getName());
            assertEquals(trelloBoard.getLists().size(), trelloBoardDto.getLists().size());
            for (int j = 0; j < trelloBoard.getLists().size(); j++) {
                TrelloList trelloList = trelloBoard.getLists().get(j);
                TrelloListDto trelloListDto = trelloBoardDto.getLists().get(j);
                assertEquals(trelloList.getId(), trelloListDto.getId());
                assertEquals(trelloList.getName(), trelloListDto.getName());
                assertEquals(trelloList.isClosed(), trelloListDto.isClosed());
            }
        }
    }

    @Test
    public void shouldMapToList() {
        // Given
        List<TrelloListDto> trelloListDtoList = Arrays.asList(
                new TrelloListDto("list1", "List 1", false),
                new TrelloListDto("list2", "List 2", true)
        );

        // When
        List<TrelloList> trelloListList = trelloMapper.mapToList(trelloListDtoList);

        // Then
        assertEquals(trelloListDtoList.size(), trelloListList.size());
        for (int i = 0; i < trelloListDtoList.size(); i++) {
            TrelloListDto trelloListDto = trelloListDtoList.get(i);
            TrelloList trelloList = trelloListList.get(i);
            assertEquals(trelloListDto.getId(), trelloList.getId());
            assertEquals(trelloListDto.getName(), trelloList.getName());
            assertEquals(trelloListDto.isClosed(), trelloList.isClosed());
        }
    }

    @Test
    public void shouldMapToListDto() {
        // Given
        List<TrelloList> trelloListList = Arrays.asList(
                new TrelloList("list1", "List 1", false),
                new TrelloList("list2", "List 2", true)
        );

        // When
        List<TrelloListDto> trelloListDtoList = trelloMapper.mapToListDto(trelloListList);

        // Then
        assertEquals(trelloListList.size(), trelloListDtoList.size());
        for (int i = 0; i < trelloListList.size(); i++) {
            TrelloList trelloList = trelloListList.get(i);
            TrelloListDto trelloListDto = trelloListDtoList.get(i);
            assertEquals(trelloList.getId(), trelloListDto.getId());
            assertEquals(trelloList.getName(), trelloListDto.getName());
            assertEquals(trelloList.isClosed(), trelloListDto.isClosed());
        }
    }

    @Test
    public void shouldMapToCardDto() {
        // Given
        TrelloCard trelloCard = new TrelloCard("Card 1", "Card Description", "top", "list1");

        // When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        // Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }

    @Test
    public void shouldMapToCard() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card 1", "Card Description", "top", "list1");

        // When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        // Then
        assertEquals(trelloCardDto.getName(), trelloCard.getName());
        assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
        assertEquals(trelloCardDto.getPos(), trelloCard.getPos());
        assertEquals(trelloCardDto.getListId(), trelloCard.getListId());
    }
}