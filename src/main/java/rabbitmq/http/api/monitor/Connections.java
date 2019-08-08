package rabbitmq.http.api.monitor;

import com.fasterxml.jackson.databind.JsonNode;
import rabbitmq.http.api.entity.ConnectionsStatus;
import rabbitmq.http.api.utils.Data;
import rabbitmq.http.api.utils.JsonUtil;

import java.io.IOException;
import java.util.*;

// 连接管理
//TODO  现在的速率单位都是B/S ，可以根据需要改成KB 或者MB，或者由前端根据数值进行适应性改变
public class Connections {
    public static String getConnectionsStatus(String url,
                                              int port, String username, String password) throws IOException {
        String URL = "http://" + url + ":" + port + "/api/connections";
        String nodeData = Data.getData(URL, username, password);

        List<ConnectionsStatus> list = new ArrayList<ConnectionsStatus>();
        JsonNode jsonNode = JsonUtil.toJsonNode(nodeData);

        Iterator<JsonNode> iterator = jsonNode.iterator();
        while (iterator.hasNext()) {
            JsonNode node = iterator.next();
            ConnectionsStatus status = new ConnectionsStatus();

            status.setConnectionName(node.get("name").asText());
            status.setChannels(node.get("channels").asInt());
            status.setState(node.get("state").asText());
            status.setSSL(node.get("ssl").asBoolean());
            status.setProtocol(node.get("protocol").asText());
            status.setFromClient(node.get("recv_oct_details").get("rate").asDouble());
            status.setToClient(node.get("send_oct_details").get("rate").asDouble());
            status.setUserName(node.get("user").asText());
            list.add(status);
        }

        return JsonUtil.toJsonString(list);
    }

    public static void main(String[] args) throws IOException {
        String str = getConnectionsStatus("192.168.1.115", 15672, "admin", "admin");
        System.out.println(str);
    }
}
