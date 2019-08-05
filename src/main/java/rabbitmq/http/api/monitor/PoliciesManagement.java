package rabbitmq.http.api.monitor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import rabbitmq.http.api.entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static rabbitmq.http.api.Constants.*;
import static rabbitmq.http.api.utils.Methods.getData;

public class PoliciesManagement {
    //demo
    public static String fetchRabbtMQUsersJsonString(String url, String username, String password) throws IOException {
        //获取数据
        String nodeData = getData(url, username, password);
        JSONArray jsonArray = JSONObject.parseArray(nodeData) ;
        JSONArray returnJsonArray = null;
        List<User> users = new ArrayList<User>();
        //遍历返回的数据，保存需要的键值对
        for(int i=0;i<jsonArray.size();i++){
            JSONObject tempJsonObject = jsonArray.getJSONObject(i);
            User user = new User();
            user.setName(tempJsonObject.getString("name"));
            user.setTags(tempJsonObject.getString("tags"));
            users.add(user);
        }

        returnJsonArray = JSONArray.parseArray(JSON.toJSONString(users));

        return returnJsonArray.toString();
    }





    public static void main(String[] args) throws IOException {

        //获取用户信息

        String strUsersList = fetchRabbtMQUsersJsonString(RABBIT_USERS_REST_URL, RABBIT_USER_NAME, RABBIT_USER_PWD);

        JSONArray jsonArray = JSONArray.parseArray(strUsersList);

        for(int i=0;i<jsonArray.size();i++){
            System.out.println(jsonArray.getJSONObject(i));
        }

    }

}
