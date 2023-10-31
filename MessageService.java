package ie.tcd.scss.social.service;

import ie.tcd.scss.social.domain.Message;
import ie.tcd.scss.social.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
            this.messageRepository = messageRepository;
    }

    public Message createMessage(String str) {
            String title = generateTitle(str);
            String body = generateBody(str);
            Message message = new Message(str,title, body);
            return messageRepository.save(message);
    }

        private String generateTitle(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i<5; i++){
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        }

        private String generateBody(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i<10; i++){
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        }

}
