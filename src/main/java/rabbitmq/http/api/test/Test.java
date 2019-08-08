package rabbitmq.http.api.test;

public class Test {
    public static void main(String[] args) throws Exception{
        Receiver receiver = new Receiver("q");
        Thread receiverThread = new Thread(receiver);
        receiverThread.start();
        Sender sender = new Sender("q");
        for (int i = 0; i < 10000; i++) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.setChannel("test");
            messageInfo.setContent("msg" + i);
            sender.sendMessage(messageInfo);
        }
    }
}
