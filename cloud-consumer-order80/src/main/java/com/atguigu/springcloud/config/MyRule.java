package com.atguigu.springcloud.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zmj
 * @date 2020/7/30 9:21
 * @Description 自定义负载均衡规则算法（轮询算法）
 */
public class MyRule extends AbstractLoadBalancerRule {

    private AtomicInteger counter;

    public MyRule() {
        this.counter = new AtomicInteger(0);
    }

    private int incrementAndGetModulo() {
        int next;
        int current;
        do {
            current = counter.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!counter.compareAndSet(current, next));
        return next;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = getLoadBalancer();
        List<Server> reachableServers = loadBalancer.getReachableServers();
        List<Server> allServers = loadBalancer.getAllServers();

        if (reachableServers.size() != 0 && allServers.size() != 0) {
            int next = incrementAndGetModulo() % allServers.size();
            Server server = allServers.get(next);
            if (server != null && server.isAlive() && server.isReadyToServe()) {
                return server;
            }
        }
        return null;
    }
}
