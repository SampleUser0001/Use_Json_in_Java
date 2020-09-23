package sample.json;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import sample.json.bean.MenuItem;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception{
        ObjectMapper mapper = new JacksonObjectMapper().getContext(MenuItem.class);

            // 読み込んだJsonの内容を表示する
        List<MenuItem> list = mapper.readValue(new File(args[0]), new TypeReference<List<MenuItem>>(){});
        for(MenuItem bean : list){
            System.out.print(bean);
            System.out.print(" : ");
                System.out.println(bean.getOnclick() == null ? "onclick is null." : "onclick is not null." );
        }
        System.out.println();

        // 再度Jsonに変換する
        System.out.println(mapper.writeValueAsString(list));
    }
}
