package application.endpoints_rest.exceptions;

import java.util.HashMap;
import java.util.Map;

public class SignUpException extends RuntimeException{

  private  Map<String, String> fields;
  public SignUpException(String message) {
    super(message);
    fields = new HashMap<>();
  }

  public void addFieldError(String field, String messageError){
    fields.put(field, messageError);
  }

  public Map<String, String> getFields() {
    return fields;
  }
}
