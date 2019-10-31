package mardld.springcloudkafkastreamspoc;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface GreetingsStreams {

    @Output("greetings-out")
    MessageChannel outboundGreetings();
}
