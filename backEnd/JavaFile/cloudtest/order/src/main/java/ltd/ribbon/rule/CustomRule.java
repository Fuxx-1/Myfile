package ltd.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CustomRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = this.getLoadBalancer();
        // 获取当前请求的服务的实例
        List<Server> reachableServers = loadBalancer.getReachableServers();
        int i = ThreadLocalRandom.current().nextInt(reachableServers.size());
        Server server = reachableServers.get(i);
        return server;
    }
}
