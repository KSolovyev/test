package sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @GetMapping(value = "/", produces = "application/json")
    public Message getHello() {
        return new Message("Hello Java!");
    }

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity postHello(@RequestBody Message message) {
        LOGGER.info(String.format("got incoming message: %s", message.message));
        return ResponseEntity.ok().build();
    }


    public static class Message {
        private String message;

        public Message(String message) {
            this.message = message;
        }

        public Message() {
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        // setter, getter, empty constructor are essential
    }
}
