package com.redfort.ecommerce.consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.redfort.ecommerce.Message;
import com.redfort.ecommerce.MessageAdapter;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class GsonDeserializer<T> implements Deserializer<Message> {

    private final Gson gson = new GsonBuilder().registerTypeAdapter(Message.class, new MessageAdapter()).create();

    @Override
    public Message deserialize(String topic, byte[] bytes) {
        return gson.fromJson(new String(bytes), Message.class);
    }
}
