package pl.minecodes.mmetrics.metric.minecraft;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.minecodes.mmetrics.rest.RestErrorResponse;

@ControllerAdvice(assignableTypes = MinecraftMetricController.class)
class MinecraftMetricRestExceptionHandler {

  @ExceptionHandler(MinecraftMetricProductNotFoundException.class)
  public ResponseEntity<?> handleMinecraftMetricProductNotFoundException(MinecraftMetricProductNotFoundException exception) {
    String errorDetails = exception.getMessage();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestErrorResponse(
        HttpStatus.NOT_FOUND.value(),
        errorDetails,
        Instant.now()
    ));
  }
}
