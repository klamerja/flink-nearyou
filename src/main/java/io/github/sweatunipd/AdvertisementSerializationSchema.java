package io.github.sweatunipd;

import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;

public class AdvertisementSerializationSchema implements SerializationSchema<Tuple2<Integer, String>> {
  private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(Tuple2<Integer, String> integerStringTuple2) {
        try {
            ObjectNode node = mapper.createObjectNode();
            node.put("rent_id",integerStringTuple2.f0);
            node.put("adv",integerStringTuple2.f1);
            return mapper.writeValueAsBytes(node);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize Tuple2 to JSON", e);
        }
    }
}
