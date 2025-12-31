package org.springaicommunity.watsonx.chat.tool;

import java.util.Map;

public interface WatsonxAiToolParameterMapper {

  Map<String, Object> convertSchema(String jsonSchema);
}
