package rabbitmq.http.api.entity;


// 指标状态实体类
public class IndexStatus {

    private int connections;

    private int channels;

    private int consumers;

    private int exchanges;

    private int queues;

    private double redelivered;

    private double publish;

    private double publishConfirm;

    private double Return;

    private double diskRead;

    private double doskWrite;

    private double deliverAutoAck;

    private double deliverManualAck;

    private double getAutoAck;

    private double getManualAck;

    private double consumerAck;

    public int getConnections() {
        return connections;
    }

    public void setConnections(int connections) {
        this.connections = connections;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public int getConsumers() {
        return consumers;
    }

    public void setConsumers(int consumers) {
        this.consumers = consumers;
    }

    public int getExchanges() {
        return exchanges;
    }

    public void setExchanges(int exchanges) {
        this.exchanges = exchanges;
    }

    public int getQueues() {
        return queues;
    }

    public void setQueues(int queues) {
        this.queues = queues;
    }

    public double getPublish() {
        return publish;
    }

    public void setPublish(double publish) {
        this.publish = publish;
    }

    public double getPublishConfirm() {
        return publishConfirm;
    }

    public void setPublishConfirm(double publishConfirm) {
        this.publishConfirm = publishConfirm;
    }

    public double getReturn_unroutable_details() {
        return Return;
    }

    public void setReturn(double Return) {
        this.Return = Return;
    }

    public double getRedelivered() {
        return redelivered;
    }

    public void setRedelivered(double redelivered) {
        this.redelivered = redelivered;
    }

    public double getDiskRead() {
        return diskRead;
    }

    public void setDiskRead(double diskRead) {
        this.diskRead = diskRead;
    }

    public double getDoskWrite() {
        return doskWrite;
    }

    public void setDoskWrite(double doskWrite) {
        this.doskWrite = doskWrite;
    }

    public double getDeliverAutoAck() {
        return deliverAutoAck;
    }

    public void setDeliverAutoAck(double deliverAutoAck) {
        this.deliverAutoAck = deliverAutoAck;
    }

    public double getDeliverManualAck() {
        return deliverManualAck;
    }

    public void setDeliverManualAck(double deliverManualAck) {
        this.deliverManualAck = deliverManualAck;
    }

    public double getGetAutoAck() {
        return getAutoAck;
    }

    public void setGetAutoAck(double getAutoAck) {
        this.getAutoAck = getAutoAck;
    }

    public double getGetManualAck() {
        return getManualAck;
    }

    public void setGetManualAck(double getManualAck) {
        this.getManualAck = getManualAck;
    }

    public double getConsumerAck() {
        return consumerAck;
    }

    public void setConsumerAck(double consumerAck) {
        this.consumerAck = consumerAck;
    }

    @Override
    public String toString() {
        return "IndexStatus{" +
                "connections=" + connections +
                ", channels=" + channels +
                ", consumers=" + consumers +
                ", exchanges=" + exchanges +
                ", queues=" + queues +
                ", redelivered=" + redelivered +
                ", publish=" + publish +
                ", publishConfirm=" + publishConfirm +
                ", Return=" + Return +
                ", diskRead=" + diskRead +
                ", doskWrite=" + doskWrite +
                ", deliverAutoAck=" + deliverAutoAck +
                ", deliverManualAck=" + deliverManualAck +
                ", getAutoAck=" + getAutoAck +
                ", getManualAck=" + getManualAck +
                ", consumerAck=" + consumerAck +
                '}';
    }
}

















