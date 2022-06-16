package sample.json.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    private int key;
    private String value;

    @JsonProperty("value2")
    private String otherName;
}