package sample.json;

import java.io.IOException;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;

import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.Produces;

// import org.springframework.http.MediaType;
import javax.ws.rs.core.MediaType; 

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonObjectMapper implements ContextResolver<ObjectMapper> {
  /** ObjectMapper */
  private ObjectMapper mapper;

  /** デフォルトコンストラクタ. */
  public JacksonObjectMapper() {
    mapper = new ObjectMapper();
    DefaultSerializerProvider.Impl dsp = new DefaultSerializerProvider.Impl();
    dsp.setNullValueSerializer(new NullValueSerializer());
    mapper.setSerializerProvider(dsp);
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return this.mapper;
  }

  public static class NullValueSerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
      jg.writeString("");
    }
  }
}
