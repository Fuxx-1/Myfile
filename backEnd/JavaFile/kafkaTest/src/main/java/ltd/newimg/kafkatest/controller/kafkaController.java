package ltd.newimg.kafkatest.controller;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class kafkaController {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @GetMapping("/send/{input}")
    public String sendFoo(@PathVariable String input) {
        this.template.send("topic_input", input);
        return input;
    }

    @KafkaListener(id = "webGroup", topics = "topic_input")
    public void listen(String input) {
        Logger.getLogger("kafkaController").info("input value: " + input);
    }
}
