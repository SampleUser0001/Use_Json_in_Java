package sample.json;

import sample.json.bean.MenuItem;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception{
        ObjectMapper mapper = new JacksonObjectMapper().getContext(MenuItem.class);
        List<MenuItem> list = mapper.readValue(new File(args[0]), new TypeReference<List<MenuItem>>(){});
        for(MenuItem bean : list){
            System.out.print(bean);
            System.out.print(" : ");
            System.out.println(bean.getOnclick() == null ? "onclick is null." : "onclick is not null." );
        }
    }
}
