# Use_Jackson

- [Use_Jackson](#use_jackson)
  - [pom.xml](#pomxml)
  - [json -> Model](#json---model)
    - [input.json](#inputjson)
    - [Model.java](#modeljava)
    - [App.java](#appjava)
  - [Model -> json](#model---json)
    - [Model.java](#modeljava-1)
    - [App.java](#appjava-1)

## pom.xml

``` xml
    <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>${jackson.version}</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>${jackson.version}</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>${jackson.version}</version>
    </dependency>

```

## json -> Model

### input.json

``` json
[
    { "key":1 , "value":"hoge" } , 
    { "key":2 , "value":"piyo" }
]
```

### Model.java

``` java
package sample.json.model;

import lombok.Data;

@Data
public class Model {
    private int key;
    private String value;
}
```

### App.java

``` java
import java.util.List;
import sample.json.model.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;


ObjectMapper mapper = new ObjectMapper();
List<Model> list
    = mapper.readValue(
        json,
        new TypeReference<List<Model>>(){}
);

```

## Model -> json

### Model.java

### App.java
