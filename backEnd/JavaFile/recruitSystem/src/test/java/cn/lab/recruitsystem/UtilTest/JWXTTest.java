package cn.lab.recruitsystem.UtilTest;

import cn.lab.recruitsystem.Util.ReturnUtil;
import cn.lab.recruitsystem.Util.XUPTVerify;
import org.junit.jupiter.api.Test;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:29
 */
public class JWXTTest {
    @Test
    public void test() throws Exception {
        XUPTVerify login = new XUPTVerify();
        System.out.println(ReturnUtil.returnMsg("登录成功", 0, login.getStuInfo("04202084", "fxx200224")));
    }
}
