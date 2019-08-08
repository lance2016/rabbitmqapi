package rabbitmq.http.api.monitor;


import com.fasterxml.jackson.databind.JsonNode;
import rabbitmq.http.api.entity.ClusterStatus;
import rabbitmq.http.api.utils.Data;
import rabbitmq.http.api.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;


// 集群管理
public class Nodes {

    public static String getRabbtMQClusterStatus(String ip, int port, String username, String password) throws IOException {
        String url = "http://" + ip + ":" + port + "/api/nodes";
        List<ClusterStatus> list = new ArrayList<>();
        String nodeData = Data.getData(url, username, password);

        if(StringUtils.isEmpty(nodeData))
            return null;

        JsonNode jsonNode = null;
        try {
            jsonNode = JsonUtil.toJsonNode(nodeData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final long base = 1048576l; //以MB为单位
        //final long base = 1073741824; //以GB为单位

        Iterator<JsonNode> iterator = jsonNode.iterator();
        while (iterator.hasNext()) {
            JsonNode next = iterator.next();
            ClusterStatus status = new ClusterStatus();

            //填充数据
            setStatus(status, next, base);

            // 放入保存
            list.add(status);
        }
        return JsonUtil.toJsonString(list);
    }

    public static String getRabbtMQClusterStatusByNodeName(String ip, int port, String username, String password, String nodeName) throws IOException {
        String url = "http://" + ip + ":" + port + "/api/nodes/" + nodeName;

        List<ClusterStatus> list = new ArrayList<>();
        String nodeData = Data.getData(url, username, password);

        if(StringUtils.isEmpty(nodeData))
            return null;

        System.out.println(nodeData);
        JsonNode jsonNode = null;

        try {
            jsonNode = JsonUtil.toJsonNode(nodeData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final long base = 1048576l; //以MB为单位
        //final long base = 1073741824; //以GB为单位
        ClusterStatus status = new ClusterStatus();

        //填充状态数据
        setStatus(status, jsonNode, base);
        list.add(status);

        return JsonUtil.toJsonString(list);
    }

    private static void setStatus(ClusterStatus status, JsonNode jsonNode, long base) {

        if (jsonNode.get("name") != null)
            status.setNodeName(jsonNode.get("name").asText());

        if (jsonNode.get("disk_free") != null)
            status.setDiskFree(jsonNode.get("disk_free").asLong() / base);

        if (jsonNode.get("fd_used") != null)
            status.setFdUsed(jsonNode.get("fd_used").asLong());

        if (jsonNode.get("mem_used") != null)
            status.setMemoryUsed(jsonNode.get("mem_used").asLong() / base);

        if (jsonNode.get("proc_used") != null)
            status.setProcUsed(jsonNode.get("proc_used").asLong());

        if (jsonNode.get("sockets_used") != null)
            status.setSocketUsed(jsonNode.get("sockets_used").asLong());

        if (jsonNode.get("proc_total") != null)
            status.setProcTotal(jsonNode.get("proc_total").asLong());

        if (jsonNode.get("fd_total") != null)
            status.setFdTotal(jsonNode.get("fd_total").asLong());

        if (jsonNode.get("sockets_total") != null)
            status.setSocketTotal(jsonNode.get("sockets_total").asLong());

        if (jsonNode.get("mem_limit") != null)
            status.setMemoryLimit(jsonNode.get("mem_limit").asLong() / base);

        //TODO 实际上rabbitmq给出的硬盘限制是最低限制，也就是剩余低于多少报警，
        //TODO 原型给出的是 已使用/总共可用的形式
        if (jsonNode.get("disk_free_limit") != null)
            status.setDiskLimit(jsonNode.get("disk_free_limit").asLong() / base);
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        //System.out.println(Nodes.getRabbtMQClusterStatus("192.168.1.116", 15672, "admin", "admin"));

        final int N = 10;
        final CountDownLatch latch = new CountDownLatch(N);
        long start = System.currentTimeMillis();
        for(int i=0;i<N;i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Nodes.getRabbtMQClusterStatus("192.168.11.116", 15672, "admin", "admin"));
                        latch.countDown();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000+"s");
    }
}
