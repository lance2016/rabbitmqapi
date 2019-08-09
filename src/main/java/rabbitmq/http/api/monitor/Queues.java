package rabbitmq.http.api.monitor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import rabbitmq.http.api.Constants;
import rabbitmq.http.api.entity.Queue;
import rabbitmq.http.api.utils.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Queues {
    //获取Channels列表
    public static String fetchRabbitMQQueues(String url, String username, String password) throws IOException {
        //获取数据
        String nodeData = Data.getData(url, username, password);
        JSONArray jsonArray = JSONObject.parseArray(nodeData) ;
        JSONArray returnJsonArray = null;
        List<Queue> queues = new ArrayList<Queue>();
        //遍历返回的数据，保存需要的键值对
        for(int i=0;i<jsonArray.size();i++){
            JSONObject tempJsonObject = jsonArray.getJSONObject(i);

            Queue queue = new Queue();
            //赋值
            if(tempJsonObject.getString("name")!=null)
                queue.setName(tempJsonObject.getString("name"));

            if(tempJsonObject.getString("policy")!=null)
                queue.setPolicy(tempJsonObject.getString("policy"));

            if(tempJsonObject.getString("message_stats")!=null){
                String message_stats = tempJsonObject.getString("message_stats");

                JSONObject json_message_stats = JSONObject.parseObject(message_stats);
                if(json_message_stats.getString("ack_details")!=null){
                    String ack_details = json_message_stats.getString("ack_details");
                    JSONObject json_ack_details = JSONObject.parseObject(ack_details);
                    if(json_ack_details.getDouble("rate")!=null)
                        queue.setAck(json_ack_details.getDouble("rate"));
                }

                String publish_details = json_message_stats.getString("publish_details");
                JSONObject json_publish_details = JSONObject.parseObject(publish_details);
                if(json_publish_details.getInteger("rate")!=null)
                    queue.setIncoming(json_publish_details.getInteger("rate"));

                String deliver_get_details = json_message_stats.getString("deliver_get_details");
                JSONObject json_deliver_get_details = JSONObject.parseObject(deliver_get_details);
                if(json_deliver_get_details.getDouble("rate")!=null)
                    queue.setDeliverGet(json_deliver_get_details.getDouble("rate"));
            }

            Map<String,String> mapArguments = new HashMap<String, String>();
            String arguments  =tempJsonObject.getString("arguments");
            JSONObject json_arguments = JSONObject.parseObject(arguments);
            if(json_arguments!=null){
                for(Map.Entry<String,Object > entry :json_arguments.entrySet()){
                    mapArguments.put(entry.getKey(),(String)entry.getValue());
                }
                queue.setArguments(mapArguments);
            }


            if(tempJsonObject.getBoolean("durable")!=null)
                queue.setDurable(tempJsonObject.getBoolean("durable"));

            queue.setState(tempJsonObject.getString("state"));

            if(tempJsonObject.getShort("messages_ready")!=null)
                queue.setReady(tempJsonObject.getShort("messages_ready"));

            if(tempJsonObject.getInteger(" messages_unacknowledged")!=null)
                queue.setUnacked(tempJsonObject.getInteger(" messages_unacknowledged"));

            if(tempJsonObject.getInteger("messages")!=null)
                queue.setTotal(tempJsonObject.getInteger("messages"));

            queues.add(queue);
        }

        returnJsonArray = JSONArray.parseArray(JSON.toJSONString(queues));

        System.out.println(returnJsonArray);
        return returnJsonArray.toString();

    }

    public static void main(String[] args) throws IOException {
        String ss = fetchRabbitMQQueues(Constants.RABBIT_QUEUES_REST_URL,Constants.RABBIT_USER_NAME,
                Constants.RABBIT_USER_PWD);

    }
}
