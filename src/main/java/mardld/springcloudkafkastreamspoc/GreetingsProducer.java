package mardld.springcloudkafkastreamspoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingsProducer {
    private final GreetingsStreams greetingsStreams;

    public GreetingsProducer(GreetingsStreams greetingsStreams) {
        this.greetingsStreams = greetingsStreams;
    }

    public void send(String message) {
        MessageChannel channel = greetingsStreams.outboundGreetings();
        boolean sent = channel.send(MessageBuilder
                .withPayload(new Greeting(message))
                .build()
        );
        log.info("message sent? {}", sent);
    }
}
