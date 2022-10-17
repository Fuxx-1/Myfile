package org.example;

import com.alibaba.fastjson2.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-16 8:47
 */
public class GenshinCenter {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<GenshinPrayRecord> genshinPrayRecords = new ArrayList<GenshinPrayRecord>();
        while (true) {
            String value = getLine();
            if (value.equals("End")) {
                break;
            } else {
                genshinPrayRecords.add(parse(value));
            }
        }
        for (GenshinPrayRecord genshinPrayRecord : genshinPrayRecords) {
            for (GenshinPrayRecord genshinPrayRecord1 : genshinPrayRecords) {
                if (genshinPrayRecord.getId().equals(genshinPrayRecord1.getId())) {
                    System.out.println("=====WARNING=====");
                }
            }
        }
        GenshinPrayRecord[] genshinPrayRecordsList = new GenshinPrayRecord[genshinPrayRecords.size()];
        int i = 0;
        for (GenshinPrayRecord genshinPrayRecord : genshinPrayRecords) {
            genshinPrayRecordsList[i] = genshinPrayRecord;
            i++;
        }
        Arrays.sort(genshinPrayRecordsList);
        try {
            writeJson(genshinPrayRecordsList);
//            writeFile(genshinPrayRecordsList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static GenshinPrayRecord parse(String prayRecord) {
        GenshinPrayRecord genshinPrayRecord = new GenshinPrayRecord();
        String[] prayRecordSplit = prayRecord.split("\t");
        genshinPrayRecord.setTime(prayRecordSplit[0]);
        genshinPrayRecord.setRank_type(prayRecordSplit[3]);
        genshinPrayRecord.setName(prayRecordSplit[1]);
        genshinPrayRecord.setItem_type(prayRecordSplit[2]);
        genshinPrayRecord.setGache_type(String.valueOf(GacheTyoeEnum.getEnumViaParam(prayRecordSplit[4]).getGacheTyoe()));
//        genshinPrayRecord.setUigf_gacha_type(genshinPrayRecord.getGache_type());
        genshinPrayRecord.setId(String.valueOf(getTimeStamp(prayRecordSplit[0]) * 1000000 + Integer.parseInt(prayRecordSplit[5]) * 100L + 73 - 612303200000000000L));
        return genshinPrayRecord;
    }

    public static Long getTimeStamp(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);
        return date.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static String getLine() {
        return in.nextLine();
    }

    public static Boolean writeFile(GenshinPrayRecord[] genshinPrayRecords) throws IOException {
        File file = new File("./out.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file.getName(), true);
        fileWriter.write("");
        for (GenshinPrayRecord genshinPrayRecord : genshinPrayRecords) {
//            fileWriter.append(genshinPrayRecord.toExcelType());
        }
        return true;
    }

    public static Boolean writeJson(GenshinPrayRecord[] genshinPrayRecords) throws IOException {
        File file = new File("./out.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file.getName(), true);
        fileWriter.write("");
        JSONObject jsonObject = new JSONObject() {{
            put("info", new HashMap<String, String>() {{
                put("uid", "169868073");
                put("lang", "zh-cn");
            }});
            put("list", genshinPrayRecords);
        }};
        fileWriter.append(jsonObject.toJSONString());
        System.out.println(jsonObject.toJSONString());
        return true;
    }
}
