package rabbitmq.http.api.test;

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class Sender extends BaseConnector {
    public Sender(String queueName) throws IOException {
        super(queueName);
    }

    public void sendMessage(Serializable object) throws IOException {
        System.out.println("开始发送消息");
        channel.basicPublish("",queueName, null, SerializationUtils.serialize(object));
    }
}

