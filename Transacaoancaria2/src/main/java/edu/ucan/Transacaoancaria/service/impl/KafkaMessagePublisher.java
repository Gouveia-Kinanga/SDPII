package edu.ucan.Transacaoancaria.service.impl;

import edu.ucan.Transacaoancaria.model.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    private static final String TOPIC = "transferencias-bancarias";
    public void senMessageToTopic(String message){
        template.send(TOPIC,message);
    }
}
