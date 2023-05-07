package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Jackson {

    public static final ObjectMapper INSTANT = new ObjectMapper();

    static {
        config(INSTANT);
    }

    public static void config(ObjectMapper mapper) {
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);//ISO
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        try {
            return INSTANT.readValue(json, classOfT);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(TreeNode treeNode, Class<T> classOfT) {
        try {
            return INSTANT.treeToValue(treeNode, classOfT);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object src) {
        try {
            return INSTANT.writeValueAsString(src);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
