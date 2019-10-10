package whtcc.edu.cn;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
private final static String URL_PATH = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569693872&di=035bbad8971b82859a7b2fd1466f4543&imgtype=jpg&er=1&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201805%2F25%2F20180525201229_X8VsH.jpeg";
    public HttpUtils() {
    }

    public static InputStream getImageViewInputStream() throws IOException {
        InputStream inputStream = null;
        URL url = new URL(URL_PATH);
        if (url != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url
                    .openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            int response_code = httpURLConnection.getResponseCode();
            if (response_code == 200) {
                inputStream = httpURLConnection.getInputStream();
            }
        }
        return inputStream;
    }
}
