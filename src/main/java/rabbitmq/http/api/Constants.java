package rabbitmq.http.api;

//待修改
public class Constants {

    //部署实例的相应ip
    public static String IP = "127.0.0.1";

    //端口号
    public static String PORT = "15672";

    //RabbitMQ的HTTP API——获取集群各个实例的状态信息，ip替换为自己部署相应实例的
    public static String RABBIT_NODES_STATUS_REST_URL = "http://"+IP+":"+PORT+"/api/nodes";


    //RabbitMQ的HTTP API——获取集群用户信息，ip替换为自己部署相应实例的
    public static String RABBIT_USERS_REST_URL = "http://"+IP+":"+PORT+"/api/users";

    //RabbitMQ的HTTP API——获取策略信息，
    public static String RABBIT_POLICIES_REST_URL = "http://"+IP+":"+PORT+"/api/policies";

    //rabbitmq的用户名
    public static String RABBIT_USER_NAME = "guest";

    //rabbitmq的密码
    public static String RABBIT_USER_PWD = "guest";
}
