package rabbitmq.http.api.entity;

public class Channel {
    private String name; //   name: "192.168.1.113:54766 -> 192.168.1.115:5672 (1)"
    private String userName;  //user:admin
    private String mode;    //不知道
    private String state;  //state:running

    private int unconfirmed; //messages_unconfirmed
    private int prefetch; // global_prefetch_count: 0,  prefetch_count: 0,
    private int unacked; //messages_unacknowledged: 0,

    private int publish;  // publish: 100

    private boolean confirm;    //confirm: false,
    private double deliverGet;// deliver_get: 100,
    private int ack;  // ack: 0

    @Override
    public String toString() {
        return "Channels{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", mode='" + mode + '\'' +
                ", state='" + state + '\'' +
                ", unconfirmed=" + unconfirmed +
                ", prefetch=" + prefetch +
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

    public int getUnacked() {
        return unacked;
    }

    public void setUnacked(int unacked) {
        this.unacked = unacked;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public double getDeliverGet() {
        return deliverGet;
    }

    public void setDeliverGet(double deliverGet) {
        this.deliverGet = deliverGet;
    }

    public int getAck() {
        return ack;
    }

    public void setAck(int ack) {
        this.ack = ack;
    }
}
