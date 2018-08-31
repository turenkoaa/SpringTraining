package com.db.screen_saver;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.TimeUnit;

public class TwoSeconds implements Scope {

    private Cache<String, Object> cache = CacheBuilder.newBuilder()
                                            .expireAfterWrite(2, TimeUnit.SECONDS)
                                            .build();
    @Override
    @SneakyThrows
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return cache.get(name, objectFactory::getObject);
    }

    @Override
    public Object remove(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object resolveContextualObject(String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getConversationId() {
        throw new UnsupportedOperationException();
    }
}