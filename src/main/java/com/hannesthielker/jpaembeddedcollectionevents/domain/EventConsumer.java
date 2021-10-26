package com.hannesthielker.jpaembeddedcollectionevents.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ArticleEventConsumer circumvents the fact, that jpa eventlisteners are not spy-able in the tests,
 * see @see <a href="https://stackoverflow.com/a/16447608/1844850">stackoverflow</a>
 */
@Component
public class EventConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(EventConsumer.class);

    public void prePersist(Object o) {
        LOG.info("PrePersist: {}", o);
    }

    public void postPersist(Object o) {
        LOG.info("PostPersist: {}", o);
    }

    public void postLoad(Object o) {
        LOG.info("PostLoad: {}", o);
    }

    public void preUpdate(Object o) {
        LOG.info("PreUpdate: {}", o);
    }

    public void postUpdate(Object o) {
        LOG.info("PostUpdate: {}", o);
    }

    public void preRemove(Object o) {
        LOG.info("PreRemove: {}", o);
    }

    public void postRemove(Object o) {
        LOG.info("PostRemove: {}", o);
    }
}
