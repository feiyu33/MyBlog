package org.feiyu.myblog.common.util;/**
 * Created by feiyu on 2016/10/20.
 */

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>Title: SystemConfig</p>
 * <p>description 读取配置文件</p>
 *
 * @author feiyu
 * @version 1.0
 * @create 2016/10/20
 */
@Service
@Lazy(false)
public class SystemConfig {

    private static Logger log = Logger.getLogger(SystemConfig.class);
    private static final Map<String,Object> config = new HashMap<String,Object>();

    /**@PostConstruct 在spring容器中初始化Bean，@PreDestroy 销毁**/
    @PostConstruct
    public void init(){
        try {
            loadProperty();
        } catch (Exception e) {
            log.warn("failed to load properties file", e);
        }
        log.info("Loading config : " + config);
    }
    private static void loadProperty() throws IOException {
        /**
         * @title: loadProperty
         * Create By feiyu
         * @description: 加载配置文件，将setting.properties文件里的配置以键值对的形式存储
         * @params:  * @param
         * @Date: 2016/10/20
         * @return: void
         */
        String path = getPropertyFilePath();
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        for (Object key : properties.keySet()){
            String k = String.valueOf(key);
            config.put(k,properties.getProperty(k));
        }
    }

    private static String getPropertyFilePath(){
        /**
         * @title: getPropertyFilePath
         * Create By feiyu
         * @description: 获取配置文件路径
         * @params:  * @param
         * @Date: 2016/10/20
         * @return: java.lang.String
         */
        /**项目根目录**/
        String path = SystemConfig.class.getClassLoader().getResource("").getPath().toString().replaceAll("%20"," ");
        /**配置文件名**/
        String file = "setting.properties";
        log.info(path+file);
        String filePath = path+file;
        return filePath;
    }
    public static String getConfig(String key) {
        /**
         * @title: getConfig
         * Create By feiyu
         * @description: 通过键取值
         * @params:  * @param key
         * @Date: 2016/10/20
         * @return: java.lang.String
         */
        return String.valueOf(config.get(key));
    }
}
