package rabbitmq.http.api.entity;

import java.util.List;
import java.util.Map;

public class Queue {
    private String name;  //name: "devQueue"

    private String policy;//   policy: "ha-all"

    private boolean durable;   //durable:true;          true则features中显示D

    private Map<String,String> arguments; //arguments: {ss: "dd",dd: "ss",xxx: "ss"},   非空则 Features 会显示 Args


    private String state; // state: "running"                      state

    private int ready; //    messages_ready:0                      messages_ready

    private int unacked; //  messages_unacknowledged: 0            messages_unacknowledged

    private int total; //      messages: 0,                        messages

    private int incoming; //  publish_details: {rate: 0}           message_stats.publish_details.rate

    private double deliverGet; //deliver_get_details: {rate: 0}    message_stats.deliver_get_details.rate

    private double ack; // ack_details: {rate: 0}                  message_stats.ack_details.rate

    @Override
    public String toString() {
        return "Queue{" +
                "name='" + name + '\'' +
                ", policy='" + policy + '\'' +
                ", durable=" + durable +
                ", arguments=" + arguments +
                ", state='" + state + '\'' +
                ", ready=" + ready +
                ", unacked=" + unacked +
                ", total=" + total +
                ", incoming=" + incoming +
                ", deliverGet=" + deliverGet +
                ", ack=" + ack +
                '}';
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public boolean isDurable() {
        return durable;
    }

    public void setDurable(boolean durable) {
        this.durable = durable;
    }

    public Map<String, String> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, String> arguments) {
        this.arguments = arguments;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getReady() {
        return ready;
    }

    public void setReady(int ready) {
        this.ready = ready;
    }

    public int getUnacked() {
        return unacked;
    }

    public void setUnacked(int unacked) {
        this.unacked = unacked;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIncoming() {
        return incoming;
    }

    public void setIncoming(int incoming) {
        this.incoming = incoming;
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
