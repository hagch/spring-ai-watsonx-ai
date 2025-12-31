package org.springaicommunity.watsonx.chat.tool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.springframework.util.StringUtils;

public class DefaultWatsonxAiToolParameterMapper implements WatsonxAiToolParameterMapper {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public Map<String, Object> convertSchema(String jsonSchema) {
    Map<String, Object> parameters = null;
    if (StringUtils.hasText(jsonSchema)) {
      try {
        parameters = objectMapper.readValue(jsonSchema, new TypeReference<>() {});
      } catch (JsonProcessingException e) {
        throw new IllegalStateException("Unable to parse input schema" + jsonSchema, e);
      }
    }
    return parameters;
  }
}
