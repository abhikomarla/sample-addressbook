package com.abhijith.challenge.model.outgoing;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@JsonAutoDetect(
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE
)
@Data
public class CreateContactResponse implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private Integer code = HttpStatus.CREATED.value();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private String message;

    @JsonProperty
    private String time;

    @JsonProperty
    private Map<String, String> params = new HashMap<>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty
    private String correlationId = UUID.randomUUID().toString();

    @Data
    public class Error implements Serializable {
        @JsonProperty
        private String message;
        @JsonProperty
        private String code;

    }

}


