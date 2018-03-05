package zw.co.tengahuku.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
    @Autowired
    private static ApplicationContext applicationContext;

    public ApplicationContextProvider() {
    }

    public static synchronized ApplicationContext getBusinessApplicationContext() {
        return applicationContext;
    }
    
   

    public static synchronized <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public synchronized void setApplicationContext(ApplicationContext ac) {
        applicationContext = ac;
    }
}
