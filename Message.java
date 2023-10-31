package ie.tcd.scss.social.domain;

import jakarta.persistence.*;

@Entity
public class Message {
        @Id
        private String messageKey;
        @Column
        private String title;
        @Column(length = 500)
        private String body;

        protected Message(){
        }
        public Message (String title, String messageKey, String body){
                this.title=title;
                this.messageKey=messageKey;
                this.body=body;
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
        public String getMessageKey() {
                return messageKey;
        }
        public void setMessageKey(String messageKey) {
                this.messageKey = messageKey;
        }
}
