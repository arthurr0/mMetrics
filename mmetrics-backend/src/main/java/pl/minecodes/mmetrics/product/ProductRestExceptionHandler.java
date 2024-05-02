package pl.minecodes.mmetrics.product;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.minecodes.mmetrics.rest.RestErrorResponse;

@ControllerAdvice(assignableTypes = ProductController.class)
class ProductRestExceptionHandler {

  @ExceptionHandler(ProductCreationException.class)
  public ResponseEntity<?> handleMetricCreationException(ProductCreationException exception) {
    String errorDetails = exception.getMessage();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        errorDetails,
        Instant.now()
    ));
  }

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<?> handleMetricNotFoundException(ProductNotFoundException exception) {
    String errorDetails = exception.getMessage();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        errorDetails,
        Instant.now()
    ));
  }

  @ExceptionHandler(ProductUpdateException.class)
  public ResponseEntity<?> handleMetricUpdateException(ProductUpdateException exception) {
    String errorDetails = exception.getMessage();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        errorDetails,
        Instant.now()
    ));
  }
}
