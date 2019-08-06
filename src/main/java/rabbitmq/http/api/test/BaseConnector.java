package rabbitmq.http.api.test;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import rabbitmq.http.api.Constants;

import java.io.IOException;

public class BaseConnector {
    protected Channel channel;
    protected Connection connection;
    protected String queueName;
    public BaseConnector(String queueName) throws IOException{
        this.queueName = queueName;
        //打开连接和创建频道
        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在主机ip或者主机名  127.0.0.1即localhost
        factory.setHost(Constants.IP);
        factory.setVirtualHost("/");
        factory.setPort(AMQP.PROTOCOL.PORT);
        factory.setUsername("admin");
        factory.setPassword("admin");
//        factory.setUsername("guest");
//        factory.setPassword("guest");


//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//
//        String EXCHANGE_NAME = "exchange.direct";
//        String QUEUE_NAME = "queue_name";
//        String ROUTING_KEY = "key";
//
//        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
//        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

        //创建连接
        connection = factory.newConnection();
        //创建频道
        channel = connection.createChannel();
        //声明创建队列
        channel.queueDeclare(queueName, false, false, false, null);
    }
}
