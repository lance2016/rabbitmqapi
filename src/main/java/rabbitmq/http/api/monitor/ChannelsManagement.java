package rabbitmq.http.api.monitor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import rabbitmq.http.api.Constants;
import rabbitmq.http.api.entity.Channel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static rabbitmq.http.api.utils.Methods.getData;

public class ChannelsManagement {

    //获取Channels列表
    public static String fetchRabbitMQChannels(String url, String username, String password) throws IOException{
        //获取数据
        String nodeData = getData(url, username, password);
        JSONArray jsonArray = JSONObject.parseArray(nodeData) ;
        JSONArray returnJsonArray = null;
        List<Channel> channels = new ArrayList<Channel>();
        //遍历返回的数据，保存需要的键值对
        for(int i=0;i<jsonArray.size();i++){
            JSONObject tempJsonObject = jsonArray.getJSONObject(i);
            Channel channel = new Channel();
            //赋值
            channel.setName(tempJsonObject.getString("name"));
            channel.setUserName(tempJsonObject.getString("user"));

            boolean confirm = tempJsonObject.getBoolean("confirm");
            boolean transactional = tempJsonObject.getBoolean("transactional");
            String mode = "";
            if(confirm)
                mode = "confirm";
            else if(transactional)
                mode ="transactional";
            channel.setMode(mode);

            channel.setState(tempJsonObject.getString("state"));

            channel.setUnconfirmed(tempJsonObject.getInteger("messages_unconfirmed"));

            int global_prefetch_count,prefetch_count;
            global_prefetch_count = tempJsonObject.getInteger("global_prefetch_count");
            prefetch_count = tempJsonObject.getInteger("prefetch_count");
            channel.setPrefetch(prefetch_count);
            channel.setGloablePrefetch(global_prefetch_count);

            channel.setUnacked(Integer.parseInt(tempJsonObject.getString("messages_unacknowledged")));

            String message_stats = tempJsonObject.getString("message_stats");
            if(message_stats!=null){
                JSONObject json_message_stats = JSONObject.parseObject(message_stats);
                String publish_details = json_message_stats.getString("publish_details");
                if(publish_details!=null){
                    JSONObject json_publish_details = JSONObject.parseObject(publish_details);
                    if(json_publish_details.getDouble("rate")!=null)
                        channel.setPublish(json_publish_details.getDouble("rate"));
                }
                String confirm_details = json_message_stats.getString("confirm_details");
                if(confirm_details!=null){
                    JSONObject json_confirm_details = JSONObject.parseObject(confirm_details);
                    if(json_confirm_details.getDouble("rate")!=null){
                        channel.setConfirm(json_confirm_details.getDouble("rate"));
                    }
                }
                String deliver_get_details = json_message_stats.getString("deliver_get_details");
                if(deliver_get_details!=null){
                    JSONObject json_deliver_get_details = JSONObject.parseObject(deliver_get_details);
                    if(json_deliver_get_details.getDouble("rate")!=null){
                        channel.setDeliverGet(json_deliver_get_details.getDouble("rate"));
                    }
                }
                String ack_details = json_message_stats.getString("ack_details");
                if(ack_details!=null){
                    JSONObject json_ack_details = JSONObject.parseObject(ack_details);
                    if(json_ack_details.getDouble("rate")!=null)
                        channel.setAck(json_ack_details.getDouble("rate"));
                }
            }
            channels.add(channel);
        }

        returnJsonArray = JSONArray.parseArray(JSON.toJSONString(channels));

        return returnJsonArray.toString();
    }

    public static void main(String[] args) throws IOException {
        String ss = fetchRabbitMQChannels(Constants.RABBIT_CHANNELS_REST_URL,Constants.RABBIT_USER_NAME,
                Constants.RABBIT_USER_PWD);
        //输出获取到的字符串
        System.out.println(ss);
    }
}
