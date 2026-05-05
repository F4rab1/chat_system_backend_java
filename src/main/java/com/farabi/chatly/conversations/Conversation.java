package com.farabi.chatly.conversations;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "conversations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conversation {
    @Id
    private String id;

    @Indexed
    private List<String> participantIds;

    private Instant createdAt = Instant.now();

    private Instant lastMessageAt;
}
