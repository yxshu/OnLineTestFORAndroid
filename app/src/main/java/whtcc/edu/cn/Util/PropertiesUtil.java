package whtcc.edu.cn.Util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;


public class PropertiesUtil {

    private String properiesName = "";
    private Context context;
    private Properties properties;

    public PropertiesUtil() {
    }

    public PropertiesUtil(String fileName, Context context) {
        this.properiesName = fileName;
        this.context = context;
        InputStream is = null;
        BufferedReader bufferedReader = null;
        try {
            is = context.getAssets().open(properiesName);
            bufferedReader = new BufferedReader(new InputStreamReader(is));
            properties = new Properties();
            properties.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                //bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 按key获取值
     *
     * @param key
     * @return
     */
    public String readProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * 获取整个配置信息
     *
     * @return
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * key-value写入配置文件
     *
     * @param key
     * @param value
     */
    public void writeProperty(String key, String value) {
        InputStream is = null;
        OutputStream os = null;
        Properties p = new Properties();
        try {
            is = new FileInputStream(properiesName);
//            is = PropertiesUtil.class.getClassLoader().getResourceAsStream(properiesName);
            p.load(is);
//            os = new FileOutputStream(PropertiesUtil.class.getClassLoader().getResource(properiesName).getFile());
            os = new FileOutputStream(properiesName);

            p.setProperty(key, value);
            p.store(os, key);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
                if (null != os)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}