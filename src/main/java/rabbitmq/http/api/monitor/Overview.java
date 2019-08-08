package rabbitmq.http.api.monitor;

import com.fasterxml.jackson.databind.JsonNode;
import rabbitmq.http.api.entity.IndexStatus;
import rabbitmq.http.api.utils.Data;
import rabbitmq.http.api.utils.JsonUtil;


import java.io.IOException;
import java.util.*;


// 指标管理
public class Overview {
    public static String getOverviewStatus(String ip,
                      int port, String username, String password) throws IOException {
        String url = "http://" + ip + ":" + port + "/api/overview";
        String nodeData = Data.getData(url, username, password);
        IndexStatus index = new IndexStatus();
        List<IndexStatus> list = new ArrayList<>();
        JsonNode jsonNode = JsonUtil.toJsonNode(nodeData);

        setStatus(index,jsonNode);

        list.add(index);
        return JsonUtil.toJsonString(list);
    }

    private static void setStatus(IndexStatus index,JsonNode jsonNode){

        //获得并填充 connections、channels、consumers、queues、exchanges
        JsonNode object_totals = jsonNode.get("object_totals");
        index.setConnections(object_totals.get("connections").asInt());
        index.setChannels(object_totals.get("channels").asInt());
        index.setConsumers(object_totals.get("consumers").asInt());
        index.setQueues(object_totals.get("queues").asInt());
        index.setExchanges(object_totals.get("exchanges").asInt());

        //获取并填充publish（速率）、confirm、return、disk read 、 disk wirte、redeliver、以及各种ACK
        JsonNode message_stats = jsonNode.get("message_stats");
        index.setPublish(message_stats.get("publish_details").get("rate").asDouble());
        index.setPublishConfirm(message_stats.get("confirm_details").get("rate").asDouble());
        index.setReturn(message_stats.get("return_unroutable_details").get("rate").asDouble());
        index.setDiskRead(message_stats.get("disk_reads_details").get("rate").asDouble());
        index.setDoskWrite(message_stats.get("disk_writes_details").get("rate").asDouble());
        index.setRedelivered(message_stats.get("redeliver_details").get("rate").asDouble());
        index.setConsumerAck(message_stats.get("ack_details").get("rate").asDouble());
        index.setDeliverAutoAck(message_stats.get("deliver_no_ack_details").get("rate").asDouble());
        index.setDeliverManualAck(message_stats.get("deliver_details").get(("rate")).asDouble());
        index.setGetAutoAck(message_stats.get("get_no_ack_details").get("rate").asDouble());
        index.setGetManualAck(message_stats.get("get_details").get("rate").asDouble());
    }

    public static void main(String[] args) throws IOException {
        String s = getOverviewStatus("192.168.1.115", 15672, "admin", "admin");
        System.out.println(s);
    }
}
