/**
 * @create: 2021-03-16 21:08
 **/
public class Server {
    private StringBuffer data = new StringBuffer();

    public void append(String str) {
        this.data.append(str).append("|");
    }

    public String[] Reverse() {
        String[] Result = this.data.toString().split("\\|");
        int center = Result.length / 2;
        int head = 0;
        int tail = Result.length - 1;
        for (int i = 0; i < center; i++) {
            String Temp = Result[head + i];
            Result[head + i] = Result[tail - i];
            Result[tail - i] = Temp;
        }
        return Result;
    }
}
