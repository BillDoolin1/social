package ie.tcd.scss.social.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Helper class to parse the output of a MessageRepository, which we want to test over REST API calls.
 *
 * This particular class MessagesResponseDTO is used to parse the output representing a whole repository, containing
 * a list of Message objects in the "_embedded" property. See example below.
 *
 * Each individual message is mapped to an object of class Message, which should be implemented in package
 * ie.tcd.scss.social.
 *
 * We are ignoring the "_links" part for now.
 *
 * {
 *     "_embedded": {
 *         "messages": [
 *             {
 *                 "title": "first title",
 *                 "body": "first body",
 *                 "_links": {
 *                     ...links...
 *                 }
 *             },
 *             ... more messages...
 *         ]
 *     },
 *     "_links": {
 *         ...links...
 *     }
 * }
 */

public class MessagesResponseDTO {

    @JsonProperty("_embedded")
    private EmbeddedMessages embeddedMessages;

    public EmbeddedMessages getEmbeddedMessages() {
        return embeddedMessages;
    }

    public void setEmbeddedMessages(EmbeddedMessages embeddedMessages) {
        this.embeddedMessages = embeddedMessages;
    }

    public static class EmbeddedMessages {

        private List<MessageResponseDTO> messages;

        /**
         * Convert the list of MessageResponseDTO objects to a list of Message objects.
         * @return List of Message objects
         */
        public List<Message> getMessages() {
            return messages.stream()
                    .map(MessageResponseDTO::toMessage)
                    .collect(Collectors.toList());
        }

        // setMessages not implemented, we could have to convert each message from Message to MessageResponseDTO
    }
}