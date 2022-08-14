package ru.dawgg.reportbuilderapi.exception;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequest;

@Configuration
public class ExceptionConfig {

    private static final String TIMESTAMP = "timestamp";
    private static final String PATH = "path";
    private static final String STATUS = "status";
    private static final String ERROR = "error";
    private static final String REQUEST_ID = "requestId";

    @Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {
            @Override
            public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
                Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);

                LinkedHashMap<String,Object> newAttrs = new LinkedHashMap<>();
                newAttrs.put(TIMESTAMP, errorAttributes.get(TIMESTAMP));
                newAttrs.put(PATH, errorAttributes.get(PATH));
                newAttrs.put(STATUS, errorAttributes.get(STATUS));
                newAttrs.put(ERROR, errorAttributes.get(ERROR));
                newAttrs.put(REQUEST_ID, UUID.randomUUID());
                return newAttrs;
            }

        };
    }
}
