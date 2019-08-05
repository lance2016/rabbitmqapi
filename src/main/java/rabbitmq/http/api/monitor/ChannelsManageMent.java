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

public class ChannelsManageMent {

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

            channels.add(channel);
        }

        returnJsonArray = JSONArray.parseArray(JSON.toJSONString(channels));

        return returnJsonArray.toString();
    }

    public static void main(String[] args) throws IOException {
        String ss = fetchRabbitMQChannels(Constants.RABBIT_CHANNELS_REST_URL,Constants.RABBIT_USER_NAME,
                Constants.RABBIT_USER_PWD);

        System.out.println(ss);
    }
}
