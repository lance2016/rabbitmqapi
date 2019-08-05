package rabbitmq.http.api.entity;

//样例
public  class User {
    private String name;
    private String tags;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}