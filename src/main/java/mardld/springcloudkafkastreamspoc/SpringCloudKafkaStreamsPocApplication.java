package mardld.springcloudkafkastreamspoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@SpringBootApplication
@Slf4j
public class SpringCloudKafkaStreamsPocApplication implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private GreetingsProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudKafkaStreamsPocApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.info("yello {}", event);
        producer.send("Hello");
    }
}
