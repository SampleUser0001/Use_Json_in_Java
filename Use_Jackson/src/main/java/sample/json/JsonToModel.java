package sample.json;

import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import sample.json.model.Model;

import java.io.IOException;

public class JsonToModel {
    public static void main( String[] args ) throws IOException {
        String json
            = Files.lines(Paths.get(Thread.currentThread()
                                          .getContextClassLoader()
                                          .getResource("input.json") 
                                          .getPath()))
                   .map(Object::toString)
                   .collect(Collectors.joining());
        
        ObjectMapper mapper = new ObjectMapper();
        List<Model> list
            = mapper.readValue(
                json,
                new TypeReference<List<Model>>(){}
        );
        
        list.stream()
            .forEach(System.out::println);

    }
}
