package rabbitmq.http.api.entity;




// 连接状态实体类
public class ConnectionsStatus {

    private String connectionName;

    private String userName;

    private String state;

    private boolean SSL;

    private String protocol;

    private int channels;

    private double fromClient;

    private double toClient;

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isSSL() {
        return SSL;
    }

    public void setSSL(boolean SSL) {
        this.SSL = SSL;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public double getFromClient() {
        return fromClient;
    }

    public void setFromClient(double fromClient) {
        this.fromClient = fromClient;
    }

    public double getToClient() {
        return toClient;
    }

    public void setToClient(double toClient) {
        this.toClient = toClient;
    }

    @Override
    public String toString() {
        return "ConnectionsStatus{" +
                "connectionName='" + connectionName + '\'' +
                ", userName='" + userName + '\'' +
                ", state='" + state + '\'' +
                ", SSL=" + SSL +
                ", protocol='" + protocol + '\'' +
                ", channels=" + channels +
                ", fromClient=" + fromClient +
                ", toClient=" + toClient +
                '}';
    }
}
