package Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;


@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData {
    private String[] error;
    private Result result;

    @Getter
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        @JsonProperty("1INCHUSD")
        private String[] _1inchUsd;
         public String last;

        public String getLast() {
            return last;
        }
    }

}