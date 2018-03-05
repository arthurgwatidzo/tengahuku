package zw.co.tengahuku.utilities;


import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zw.co.tengahuku.exception.ApplicationContextProvider;

public class BaseEntityListener {
    private static final Logger log = LoggerFactory.getLogger(BaseEntityListener.class);

    public BaseEntityListener() {
    }

    @PrePersist
    public void prePersistBaseEntity(BaseEntity object) {
        log.trace("Running prePersist for " + object.getClass().getName());
        this.getBaseEntityListenerBean().prePersist(object);
    }

    @PreUpdate
    public void preUpdateBaseEntity(BaseEntity object) {
        log.trace("Running preUpdate for " + object.getClass().getName());
        this.getBaseEntityListenerBean().preUpdate(object);
    }

    @PostPersist
    public void postPersistBaseEntity(BaseEntity object) {
        log.trace("Running postPersist for " + object.getClass().getName());
        this.getBaseEntityListenerBean().postPersist(object);
    }

    @PostUpdate
    public void postUpdateBaseEntity(BaseEntity object) {
        log.trace("Running postUpdate for " + object.getClass().getName());
        this.getBaseEntityListenerBean().postUpdate(object);
    }

    private BaseEntityListenerBean getBaseEntityListenerBean() {
        return (BaseEntityListenerBean)ApplicationContextProvider.getBean(BaseEntityListenerBean.class);
    }
}
