package application.endpoints_rest.exceptions;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class RestControllerHandlerException implements ExceptionMapper<Throwable> {


  @Override
  public Response toResponse(Throwable ex) {

    int status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
    ErrorResponse error = new ErrorResponse();
    error.setStatus(Status.INTERNAL_SERVER_ERROR.getStatusCode());
    error.setMessage("Server internal error");

    if(ex.getCause() instanceof NotFoundException){
      status = Status.NOT_FOUND.getStatusCode();
      error.setMessage("Path not found");
    }

    if (ex.getCause() instanceof SignUpException) {
      status = Response.Status.BAD_REQUEST.getStatusCode();
      error.setMessage("Sign up error");
      for (String field : ((SignUpException) ex.getCause()).getFields().keySet()) {

        error.getErrors().put(field, ((SignUpException) ex.getCause()).getFields().get(field));
      }
    }

    return Response.status(status).entity(error).build();
  }

  public static class ErrorResponse {

    private int status;
    private Map<String, String> errors = new HashMap<>();
    private String message;

    public void setStatus(int status) {
      this.status = status;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public int getStatus() {
      return status;
    }

    public Map<String, String> getErrors() {
      return errors;
    }

    public String getMessage() {
      return message;
    }
  }
}
