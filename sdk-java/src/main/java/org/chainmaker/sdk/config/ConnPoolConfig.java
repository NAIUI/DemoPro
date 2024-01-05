package org.chainmaker.sdk.config;

/**
 * 连接池配置
 */
public class ConnPoolConfig {

    /**
     * 最大连接数
     */
    private Integer maxTotal;

    /**
     * 最少空闲连接
     */
    private Integer minIdle;


    /**
     * 最大空闲连接
     */
    private Integer maxIdle;

    /**
     * 连接空闲最小保活时间，默认即为30分钟(18000000)，单位：ms
     */
    private Integer minEvictableIdleTime;

    /**
     * 回收空闲线程的执行周期，单位毫秒。默认值10000ms（10s） ，-1 表示不启用线程回收资源，单位：ms
     */
    private Integer timeBetweenEvictionRuns;

    /**
     * 当没有空闲连接时，获取连接阻塞等待时间，单位：ms
     */
    private Integer  maxWaitMillis;

    /**
     * 没有空闲连接时，获取连接是否阻塞
     */

    private boolean blockWhenExhausted;

    public ConnPoolConfig() {
        this.maxTotal = 3;
        this.minIdle = 0;
        this.maxIdle = 3;
        this.maxWaitMillis = 3000;
        this.minEvictableIdleTime = 350000;
        this.timeBetweenEvictionRuns =10000;
    }

    public boolean isBlockWhenExhausted() {
        return blockWhenExhausted;
    }

    public void setBlockWhenExhausted(boolean blockWhenExhausted) {
        this.blockWhenExhausted = blockWhenExhausted;
    }
    public Integer getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(Integer maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }


    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinEvictableIdleTime() {
        return minEvictableIdleTime;
    }

    public void setMinEvictableIdleTime(Integer minEvictableIdleTime) {
        this.minEvictableIdleTime = minEvictableIdleTime;
    }

    public Integer getTimeBetweenEvictionRuns() {
        return timeBetweenEvictionRuns;
    }

    public void setTimeBetweenEvictionRuns(Integer timeBetweenEvictionRuns) {
        this.timeBetweenEvictionRuns = timeBetweenEvictionRuns;
    }
}
