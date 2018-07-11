package application.data.service;

import application.data.model.Message;
import application.data.repository.MessageRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageService {
    private static final Logger logger = LogManager.getLogger(MessageService.class);

    @Autowired
    private MessageRepository messageRepository;


    public boolean addNewChat(Message message){
        try {
            messageRepository.save(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Message getMessage (int id){
        return messageRepository.getOne(id);
    }

    public int getLastMessageId(){
        try {
            return messageRepository.getLastMessgeId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Message> getListMessage(int minid, int maxid){
        try {
            return messageRepository.getListMessage(minid,maxid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
