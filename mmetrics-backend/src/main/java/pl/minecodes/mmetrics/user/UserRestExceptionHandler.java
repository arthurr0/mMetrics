package pl.minecodes.mmetrics.user;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.minecodes.mmetrics.rest.RestErrorResponse;

@ControllerAdvice(assignableTypes = UserController.class)
class UserRestExceptionHandler {

  @ExceptionHandler(UserCreationException.class)
  public ResponseEntity<?> handleMetricCreationException(UserCreationException exception) {
    String errorDetails = exception.getMessage();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        errorDetails,
        Instant.now()
    ));
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<?> handleMetricNotFoundException(UserNotFoundException exception) {
    String errorDetails = exception.getMessage();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        errorDetails,
        Instant.now()
    ));
  }
}
