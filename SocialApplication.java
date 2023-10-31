package ie.tcd.scss.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ie.tcd.scss.social.service.MessageService;

@SpringBootApplication
public class SocialApplication implements CommandLineRunner {
	@Autowired
	private MessageService messageService;

	public static void main(String[] args) {SpringApplication.run(SocialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	createMessage();
	}

	private void createMessage(){
		messageService.createMessage("a");
		messageService.createMessage("ab");
		messageService.createMessage("xyz");
	}

}