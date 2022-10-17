package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-16 8:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenshinPrayRecord implements Comparable<GenshinPrayRecord> {
    private String count = "1";
    private String uid = "169868073";
    private String lang = "zh_cn";
    private String time;
    private String item_id = "";
    private String gache_type;
    private String id;
    private String item_type;
    private String rank_type;
    private String name;
//    private String uigf_gacha_type;

//    public String toExcelType() {
//        return gache_type + "\t" +
//                id + "\t" +
//                item_type + "\t" +
//                name + "\t" +
//                uigf_gacha_type + "\n";
//    }

    @Override
    public int compareTo(GenshinPrayRecord o) {
        Long result = Long.parseLong(o.getId()) - Long.parseLong(this.getId());
        if (result > 0) {
            return 1;
        } else if (result == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
