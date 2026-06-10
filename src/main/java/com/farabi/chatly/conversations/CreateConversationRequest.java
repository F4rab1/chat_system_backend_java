package com.farabi.chatly.conversations;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateConversationRequest {
    @NotBlank
    private String participantId;
}
