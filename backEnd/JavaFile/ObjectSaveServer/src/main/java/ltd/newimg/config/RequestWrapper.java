package ltd.newimg.config;

import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author Eleun
 * @Description
 * @create 2022-04-23 16:55
 */
public class RequestWrapper extends HttpServletRequestWrapper {
    private final byte[] body;

    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        //保存一份InputStream，将其转换为字节数组
        body = StreamUtils.copyToByteArray(request.getInputStream());
    }

    /**
     * 获取请求体
     * @return String 请求体数据
     */
    public String getBodyString(){
        return new String(body, StandardCharsets.UTF_8);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        //把保存好的InputStream，传下去

        final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }
        };
    }
}
