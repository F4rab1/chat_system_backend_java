package com.farabi.chatly.conversations;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConversationRepository extends MongoRepository<Conversation, String> {

    List<Conversation> findByParticipantIdsContaining(String userId);
}
