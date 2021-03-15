public class Service {
    /**
     * 输入数据并且返回输入数据的最大值与最小值
     *
     * @param count 输入数据的个数
     * @return 包含两个数据，第一个是最大值，第二个是最小值
     */
    public int[] stat(int count) {
        int[] result = new int[2];
        int[] data = new int[count];
        for (int i = 0; i < data.length; i++) {
            data[i] = InputUtil.getInt("请输入第“" + (i+1) + "”个数字");
        }
        result[0] = data[0];
        result[1] = data[0];
        for (int dataNum : data) {
            if (dataNum > result[0]) {
                result[0] = dataNum;
            }
            if (dataNum < result[1]) {
                result[1] = dataNum;
            }
        }
        return result;
    }
}
