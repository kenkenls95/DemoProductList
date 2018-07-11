package application.controller.socket;

import application.data.model.Message;
import application.data.service.MessageService;
import application.model.BaseApiResult;
import application.model.DataApiResult;
import application.model.MessageModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/chat")
public class ChatApiController {

    @Autowired
    MessageService messageService;

    @GetMapping("/getchat/{messageid}")
    public BaseApiResult getAll(@PathVariable int messageid){
        DataApiResult result = new DataApiResult();
        ModelMapper modelMapper = new ModelMapper();
        try {
            int maxid = messageid - 1;
            int minid = messageid - 10;
            ArrayList<Message> messages = messageService.getListMessage(minid,maxid);
            ArrayList<MessageModel> messageModels = new ArrayList<>();
            for(Message m : messages){
                messageModels.add(modelMapper.map(m, MessageModel.class));
            }
            result.setSuccess(true);
            result.setData(messageModels);
            result.setMessage("success");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @GetMapping("/lastid")
    public BaseApiResult getLastId(){
        DataApiResult result = new DataApiResult();
        try {
            int id = messageService.getLastMessageId();
            result.setSuccess(true);
            result.setData(id);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }
}
