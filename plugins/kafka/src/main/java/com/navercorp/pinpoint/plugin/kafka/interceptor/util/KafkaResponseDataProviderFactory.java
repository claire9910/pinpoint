package com.navercorp.pinpoint.plugin.kafka.interceptor.util;

import com.navercorp.pinpoint.plugin.kafka.KafkaVersion;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.message.FetchResponseData;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public final class KafkaResponseDataProviderFactory {

    public static KafkaResponseDataProvider getResponseDataProvider(int version, Method responseDataMethod) {
        switch (version) {
            case KafkaVersion.KAFKA_VERSION_LOW:
                return new Kafka2ResponseDataProvider(responseDataMethod);
            case KafkaVersion.KAFKA_VERSION_3_1:
                return new Kafka3ResponseDataProvider();
            default:
                return new UnsupportedResponseDataProvider();
        }
    }

}
