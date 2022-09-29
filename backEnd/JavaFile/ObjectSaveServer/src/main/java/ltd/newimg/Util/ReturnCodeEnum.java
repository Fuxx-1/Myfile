package ltd.newimg.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-09-27 17:52
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ReturnCodeEnum {
    TRANSPORT_FAIL(-2, "传输失败"),
    SYSTEM_FAILED(-1, "系统错误"),
    TEST(0, "Welcome"),
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    OUT_OF_MEMORY(2, "初始化失败，文件过大"),
    REPEAT(3, "文件重复"),
    NEED_INIT(4, "请先初始化该文件"),
    CHECK_FAIL(5, "校验失败"),
    HAS_MERGED(6, "文件已被合并"),
    NO_FILENAME(7, "文件名缺失"),
    ACCESS_DENIED(1001, "登录过期");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
