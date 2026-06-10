package com.farabi.chatly.conversations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ConversationService {

    private final ConversationRepository conversationRepository;

    public Conversation createOrGet(String userId, CreateConversationRequest request) {

        String participantId = request.getParticipantId();

        List<Conversation> conversations =
                conversationRepository.findByParticipantIdsContaining(userId);

        for (Conversation c : conversations) {
            if (c.getParticipantIds().contains(participantId)) {
                return c;
            }
        }

        Conversation conversation = new Conversation();

        List<String> participants = new ArrayList<>();
        participants.add(userId);
        participants.add(participantId);

        conversation.setParticipantIds(participants);

        return conversationRepository.save(conversation);
    }
}
