package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TrelloBadges {

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("attachmentsByType")
    private AttachmentsByType attachmentsByType;

    @Data
    public static class AttachmentsByType {

        @JsonProperty("trello")
        private TrelloAttachment trello;
    }

    @Data
    public static class TrelloAttachment {

        @JsonProperty("board")
        private int board;

        @JsonProperty("card")
        private int card;
    }
}
