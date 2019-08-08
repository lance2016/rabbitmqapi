package rabbitmq.http.api.monitor;

import com.fasterxml.jackson.databind.JsonNode;
import rabbitmq.http.api.Constants;
import rabbitmq.http.api.entity.ConnectionsStatus;
import rabbitmq.http.api.utils.Data;
import rabbitmq.http.api.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.*;

// 连接管理
//TODO  现在的速率单位都是B/S ，可以根据需要改成KB 或者MB，或者由前端根据数值进行适应性改变
public class Connections {
    public static String getConnectionsStatus(String url,
                                              int port, String username, String password) throws IOException {
        String URL = "http://" + url + ":" + port + "/api/connections";
        String nodeData = Data.getData(URL, username, password);

        if(StringUtils.isEmpty(nodeData))
            return null;

        List<ConnectionsStatus> list = new ArrayList<>();
        JsonNode jsonNode = JsonUtil.toJsonNode(nodeData);

        Iterator<JsonNode> iterator = jsonNode.iterator();
        while (iterator.hasNext()) {

            JsonNode node = iterator.next();

            ConnectionsStatus status = new ConnectionsStatus();

            setStatus(status, node);

            list.add(status);
        }

        return JsonUtil.toJsonString(list);
    }

    private static void setStatus(ConnectionsStatus status, JsonNode node) {
        if (node.get("name") != null)
            status.setConnectionName(node.get("name").asText());

        if (node.get("channels") != null)
            status.setChannels(node.get("channels").asInt());

        if (node.get("state") != null)
            status.setState(node.get("state").asText());

        if (node.get("ssl") != null)
            status.setSSL(node.get("ssl").asBoolean());

        if (node.get("protocol") != null)
            status.setProtocol(node.get("protocol").asText());

        if (node.get("recv_oct_details").get("rate") != null)
            status.setFromClient(node.get("recv_oct_details").get("rate").asDouble());

        if (node.get("send_oct_details").get("rate") != null)
            status.setToClient(node.get("send_oct_details").get("rate").asDouble());

        if (node.get("user") != null)
            status.setUserName(node.get("user").asText());
    }

    public static void main(String[] args) throws IOException {
        String str = getConnectionsStatus(Constants.IP, Integer.valueOf(Constants.PORT), Constants.RABBIT_USER_NAME,
                Constants.RABBIT_USER_PWD);
        System.out.println(str);
    }
}
