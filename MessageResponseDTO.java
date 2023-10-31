package ie.tcd.scss.social.domain;

/**
 * Helper class to parse the output of a MessageRepository, which we want to test over REST API calls.
 *
 * This particular class MessageResponseDTO is used to parse the output representing a single message. See example
 * below.
 *
 * Note that the id "messageKey" is not part of that JSON output as an explicit property, but implicitly contained in
 * the self and message link. The getMessageKey() method extracts the id from the self link.
 *
 * {
 *     "title": "aaaaa",
 *     "body": "aaaaaaaaaa",
 *     "_links": {
 *         "self": {
 *             "href": "http://localhost:8080/messages/a"
 *         },
 *         "message": {
 *             "href": "http://localhost:8080/messages/a"
 *         }
 *     }
 * }
 */

public class MessageResponseDTO {

    private String title;
    private String body;
    private Links _links;

    /**
     * Extract the id messageKey from the self link.
     * @return messageKey the extracted id
     */
    public String getMessageKey() {
        String selfLink = this._links.getSelf().getHref();
        return selfLink.substring(selfLink.lastIndexOf('/') + 1);
    }

    /**
     * Convert this MessageResponseDTO object to a Message object.
     *
     * @return Message object
     */
    public Message toMessage() {
        return new Message(getMessageKey(), getTitle(), getBody());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    public static class Links {
        private HrefLink self;
        private HrefLink message;

        public HrefLink getSelf() {
            return self;
        }

        public void setSelf(HrefLink self) {
            this.self = self;
        }

        public HrefLink getMessage() {
            return message;
        }

        public void setMessage(HrefLink message) {
            this.message = message;
        }
    }

    public static class HrefLink {
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }
}