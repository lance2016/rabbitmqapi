package rabbitmq.http.api.entity;

public class Channel {
    private String name; //   name: "192.168.1.113:54766 -> 192.168.1.115:5672 (1)"
    private String userName;  //user:admin
    private String mode;    //由confirm和transactional决定 ，都为false则不显示
    private String state;  //state:running
    private int unconfirmed; //messages_unconfirmed
    private int prefetch; //  对应 global_prefetch_count: 0,  prefetch_count: 0;此处新建两个变量对应
    private int gloablePrefetch;
    private int unacked; //messages_unacknowledged,

    private double publish;  // message_stats.publish_details.rate
    private double confirm;    //message_stats.confirm_details.rate
    private double deliverGet;// message_stats.deliver_get_details.rate
    private double ack;  // message_stats.ack_details.rate

    @Override
    public String toString() {
        return "Channel{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", mode='" + mode + '\'' +
                ", state='" + state + '\'' +
                ", unconfirmed=" + unconfirmed +
                ", prefetch=" + prefetch +
                ", gloablePrefetch=" + gloablePrefetch +
                ", unacked=" + unacked +
                ", publish=" + publish +
                ", confirm=" + confirm +
                ", deliverGet=" + deliverGet +
                ", ack=" + ack +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(int unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

    public int getPrefetch() {
        return prefetch;
    }

    public void setPrefetch(int prefetch) {
        this.prefetch = prefetch;
    }

    public int getGloablePrefetch() {
        return gloablePrefetch;
    }

    public void setGloablePrefetch(int gloablePrefetch) {
        this.gloablePrefetch = gloablePrefetch;
    }

    public int getUnacked() {
        return unacked;
    }

    public void setUnacked(int unacked) {
        this.unacked = unacked;
    }

    public double getPublish() {
        return publish;
    }

    public void setPublish(double publish) {
        this.publish = publish;
    }

    public double getConfirm() {
        return confirm;
    }

    public void setConfirm(double confirm) {
        this.confirm = confirm;
    }

    public double getDeliverGet() {
        return deliverGet;
    }

    public void setDeliverGet(double deliverGet) {
        this.deliverGet = deliverGet;
    }

    public double getAck() {
        return ack;
    }

    public void setAck(double ack) {
        this.ack = ack;
    }
}
