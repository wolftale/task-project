package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloBadgesTest {

    @Test
    public void shouldSetAndGetVotes() {
        // Given
        int votes = 5;
        TrelloBadges trelloBadges = new TrelloBadges();

        // When
        trelloBadges.setVotes(votes);
        int retrievedVotes = trelloBadges.getVotes();

        // Then
        assertEquals(votes, retrievedVotes);
    }

    @Test
    public void shouldSetAndGetAttachmentsByType() {
        // Given
        TrelloBadges.AttachmentsByType attachmentsByType = new TrelloBadges.AttachmentsByType();
        TrelloBadges trelloBadges = new TrelloBadges();

        // When
        trelloBadges.setAttachmentsByType(attachmentsByType);
        TrelloBadges.AttachmentsByType retrievedAttachmentsByType = trelloBadges.getAttachmentsByType();

        // Then
        assertEquals(attachmentsByType, retrievedAttachmentsByType);
    }

    @Test
    public void shouldSetAndGetTrelloAttachment() {
        // Given
        TrelloBadges.TrelloAttachment trelloAttachment = new TrelloBadges.TrelloAttachment();
        TrelloBadges.AttachmentsByType attachmentsByType = new TrelloBadges.AttachmentsByType();
        attachmentsByType.setTrello(trelloAttachment);
        TrelloBadges trelloBadges = new TrelloBadges();

        // When
        trelloBadges.setAttachmentsByType(attachmentsByType);
        TrelloBadges.TrelloAttachment retrievedTrelloAttachment = trelloBadges.getAttachmentsByType().getTrello();

        // Then
        assertEquals(trelloAttachment, retrievedTrelloAttachment);
    }

    @Test
    public void shouldSetAndGetBoardInTrelloAttachment() {
        // Given
        int board = 1;
        TrelloBadges.TrelloAttachment trelloAttachment = new TrelloBadges.TrelloAttachment();
        trelloAttachment.setBoard(board);
        TrelloBadges.AttachmentsByType attachmentsByType = new TrelloBadges.AttachmentsByType();
        attachmentsByType.setTrello(trelloAttachment);
        TrelloBadges trelloBadges = new TrelloBadges();

        // When
        trelloBadges.setAttachmentsByType(attachmentsByType);
        int retrievedBoard = trelloBadges.getAttachmentsByType().getTrello().getBoard();

        // Then
        assertEquals(board, retrievedBoard);
    }

    @Test
    public void shouldSetAndGetCardInTrelloAttachment() {
        // Given
        int card = 2;
        TrelloBadges.TrelloAttachment trelloAttachment = new TrelloBadges.TrelloAttachment();
        trelloAttachment.setCard(card);
        TrelloBadges.AttachmentsByType attachmentsByType = new TrelloBadges.AttachmentsByType();
        attachmentsByType.setTrello(trelloAttachment);
        TrelloBadges trelloBadges = new TrelloBadges();

        // When
        trelloBadges.setAttachmentsByType(attachmentsByType);
        int retrievedCard = trelloBadges.getAttachmentsByType().getTrello().getCard();

        // Then
        assertEquals(card, retrievedCard);
    }

}