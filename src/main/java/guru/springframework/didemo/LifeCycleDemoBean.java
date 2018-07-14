package guru.springframework.didemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    @Override
    public void setBeanName(String s) {
        System.out.println("1. Jestem w setBeanName"+s);

    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("2. Jestem w setBeanFactory"+beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("3. Jestem w setApplicationContext");
    }

    public void beforeInit(){
        System.out.println("4. Jestem w beforeInit");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("5. Jestem w postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6. Jestem w afterPropertiesSet");
    }

    public void afterInit(){
        System.out.println("7. Jestem w afterInit");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Jestem w preDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Jestem w destroy");
    }
}
