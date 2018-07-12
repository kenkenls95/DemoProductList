package application.controller.socket;

import application.data.model.ChatMessage;
import application.data.model.Message;
import application.data.model.User;
import application.data.service.MessageService;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Date;


@Controller
public class ChatController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        User user = userService.findUserByUsername(chatMessage.getSender());
        Message message = new Message();
        message.setUserid(user.getId());
        message.setUsername(chatMessage.getSender());
        message.setContent(chatMessage.getContent());
        message.setDate(new Date());
        message.setReply(false);
        message.setReplyid(0);
        message.setEmail(user.getEmail());
        messageService.addNewChat(message);
        chatMessage.setId(messageService.getLastMessageId());
        chatMessage.setDate(new Date());
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        chatMessage.setDate(new Date());
        return chatMessage;
    }


    @MessageMapping("/chat.sendMessageClient")
    @SendTo("/topic/public")
    public ChatMessage sendMessageClient(@Payload ChatMessage chatMessage) {
//        User user = userService.findUserByUsername(chatMessage.getSender());
//        Message message = new Message();
//        message.setUserid(user.getId());
//        message.setUsername(chatMessage.getSender());
//        message.setContent(chatMessage.getContent());
//        message.setDate(new Date());
//        message.setReply(false);
//        message.setReplyid(0);
//        message.setEmail(user.getEmail());
//        messageService.addNewChat(message);
//        chatMessage.setId(messageService.getLastMessageId());
//        chatMessage.setDate(new Date());
        return chatMessage;
    }

    @MessageMapping("/chat.addUserClient")
    @SendTo("/topic/public")
    public ChatMessage addUserClient(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }



}
