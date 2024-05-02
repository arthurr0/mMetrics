package pl.minecodes.mmetrics.rest;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestErrorResponse {

  private int status;
  private String message;
  private Instant timestamp;

}
