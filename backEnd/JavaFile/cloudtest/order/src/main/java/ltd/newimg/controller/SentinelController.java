package ltd.newimg.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@Slf4j
public class SentinelController {

    public static final String ROESOURCE_NAME = "SentinelTest";
    public static final String USER_ROESOURCE_NAME = "user";
    public static final String DEGRADE_ROESOURCE_NAME = "degrade";

    @RequestMapping("/block")
    public String hello() {
        Entry entry = null;
        try {
            entry = SphU.entry(ROESOURCE_NAME);
            String str = "sentinel String";
            log.info("=====" + str + "=====");
            return str;
        } catch (BlockException e1) {
            log.info("被流控了");
            return "被流控了";
        } catch (Exception ex) {
            Tracer.traceEntry(ex, entry);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return null;
    }

    @PostConstruct
    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        List<DegradeRule> degradeRules = new ArrayList<>();

        FlowRule rule = new FlowRule();
        rule.setResource(ROESOURCE_NAME);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rules.add(rule);

        FlowRule rule2 = new FlowRule();
        rule2.setResource(USER_ROESOURCE_NAME);
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setCount(1);
        rules.add(rule2);

        DegradeRule rule3 = new DegradeRule();
        rule3.setResource(DEGRADE_ROESOURCE_NAME);
        rule3.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        rule3.setCount(2);
        rule3.setMinRequestAmount(10);
        rule3.setTimeWindow(10);
        degradeRules.add(rule3);

        FlowRuleManager.loadRules(rules);
        DegradeRuleManager.loadRules(degradeRules);
    }

    @RequestMapping("/anno")
    @SentinelResource(value = USER_ROESOURCE_NAME, fallback = "ExceptionSolve", blockHandler = "blockTest")
    public String test() {
        if (new Random().nextInt(2) == 1) {
            throw new RuntimeException("RandomException");
        }
        return "anno";
    }

    public String blockTest(BlockException ex) {
        return ex + " | blocked!";
    }

    public String ExceptionSolve(Throwable e) {
        return e + " | ExceptionSolve!";
    }

    @RequestMapping("/degrade")
    @SentinelResource(value = DEGRADE_ROESOURCE_NAME, entryType = EntryType.IN, blockHandler = "blockDegrade")
    public String degrade() {
        if (new Random().nextInt(2) == 1) {
            throw new RuntimeException("RandomException");
        }
        return "degrade";
    }

    public String blockDegrade(BlockException e) {
        return e + " | blockDegrade!";
    }
}
