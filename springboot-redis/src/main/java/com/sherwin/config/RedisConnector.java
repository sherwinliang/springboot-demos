package com.sherwin.config;

//@Component
//@PropertySource("classpath:/applicationRedis.properties")
public class RedisConnector {

    //@Value("@redis.hostName@")
    private String hostName;
    //@Value("@redis.port@")
    private int port;
    //@Value("@redis.password@")
    private String password;
    //@Value("@redis.dbIndex@")
    private int dbIndex;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(Integer dbIndex) {
        this.dbIndex = dbIndex;
    }

    @Override
    public String toString() {
        return "RedisConnector{" +
                "hostName='" + hostName + '\'' +
                ", port=" + port +
                ", password='" + password + '\'' +
                ", dbIndex=" + dbIndex +
                '}';
    }
}
