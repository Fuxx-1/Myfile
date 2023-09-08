package ltd.newimg.booksystem.Util.en;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ReturnCodeEnum {
    DATA_ERROR(-3, "数据写入失败"),
    TRANSPORT_FAIL(-2, "传输失败"),
    SYSTEM_FAILED(-1, "系统错误"),
    TEST(0, "Welcome"),
    SUCCESS(0, "成功"),
    PART_SUCCESS(0, "部分成功"),
    FAIL(1, "失败"),
    NAME_REPEAT(2, "用户名已被使用"),
    WRONG_PASSWORD(3, "密码错误"),
    ACCESS_DENIED(1001, "请登录");

    private Integer code;
    private String msg;
}
