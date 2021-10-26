package com.hannesthielker.jpaembeddedcollectionevents.domain;

import org.springframework.stereotype.Component;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Component
@SuppressWarnings("JpaEntityListenerInspection")
public class EventListener {
    private final EventConsumer eventConsumer;

    public EventListener(EventConsumer eventConsumer) {
        this.eventConsumer = eventConsumer;
    }

    @PrePersist
    public void prePersist(Object o) {
        eventConsumer.prePersist(o);
    }

    @PostPersist
    public void postPersist(Object o) {
        eventConsumer.postPersist(o);
    }

    @PostLoad
    public void postLoad(Object o) {
        eventConsumer.postLoad(o);
    }

    @PreUpdate
    public void preUpdate(Object o) {
        eventConsumer.preUpdate(o);
    }

    @PostUpdate
    public void postUpdate(Object o) {
        eventConsumer.postUpdate(o);
    }

    @PreRemove
    public void preRemove(Object o) {
        eventConsumer.preRemove(o);
    }

    @PostRemove
    public void postRemove(Object o) {
        eventConsumer.postRemove(o);
    }

}
