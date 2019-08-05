package rabbitmq.http.api.two;

public class Test {
    public static void main(String[] args) throws Exception{
        Receiver receiver = new Receiver("devQueue");
        Thread receiverThread = new Thread(receiver);
        receiverThread.start();
        Sender sender = new Sender("devQueue");
        for (int i = 0; i < 100; i++) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.setChannel("test");
            messageInfo.setContent("msg" + i);
            sender.sendMessage(messageInfo);
        }
    }
}
