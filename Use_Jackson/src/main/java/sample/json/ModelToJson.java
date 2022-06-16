package sample.json;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import sample.json.model.Model;

public class ModelToJson {
    public static void main( String[] args ) throws JsonProcessingException {
        List<Model> list = new ArrayList<Model>();
        list.add(new Model(1,"hoge","hogehoge"));
        list.add(new Model(2,"piyo","piyopiyo"));
        
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(list));
    }
}
