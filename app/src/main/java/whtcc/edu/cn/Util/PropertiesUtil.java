package whtcc.edu.cn.Util;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class PropertiesUtil {

    private String properiesName;
    private Properties properties;

    public PropertiesUtil(String fileName, Context context) {
        this.properiesName = fileName;
        InputStream is = null;
        try {
            is = context.getAssets().open(properiesName);
            properties = new Properties();
            properties.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 按key获取值
     *
     * @param key 键
     * @return 根据键查到的值
     */
    public String readProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * 获取整个配置信息
     *
     * @return 获取整个配置信息
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * key-value写入配置文件
     *
     * @param key   键
     * @param value 值
     */
    public boolean writeProperty(String key, String value) {
        boolean result = false;
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
            result = true;
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
        return result;
    }
}