package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GacheTyoeEnum {
    BeginnersPray("新手祈愿", 100),
    permanentPray("常驻祈愿", 200),
    CharacterActivityPray("角色活动祈愿", 301),
    CharacterActivityPray2("角色活动祈愿-2", 400),
    WeaponActivityPray("武器活动祈愿", 302);

    private String zh_cn;
    private Integer gacheTyoe;

    /**
     * 根据枚举类的某个成员变量(参数)来反推该枚举具体实例
     * @param param 来反推枚举类型的指定实例的成员变量
     * @return 返回符合该实例成员参数的指定实例
     */
    public static GacheTyoeEnum getEnumViaParam(String param) {
        for (GacheTyoeEnum gacheTyoeEnum : GacheTyoeEnum.values()) {
            if (param.equals(gacheTyoeEnum.getZh_cn())) {
                return gacheTyoeEnum;
            }
        }
        return null;
    }
}
