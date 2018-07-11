package application.data.service;

import application.data.model.ChatMessage;
import application.data.repository.ChatMessageRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private static final Logger logger = LogManager.getLogger(ChatService.class);

    @Autowired
    private ChatMessageRepository chatUserRepository;


    public boolean addNewChat(ChatMessage chatMessage){
        try {
            chatUserRepository.save(chatMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
