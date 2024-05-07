package pl.minecodes.mmetrics.metric;

public class MetricNotFoundException extends RuntimeException {

    public MetricNotFoundException(String message) {
      super(message);
    }

    public MetricNotFoundException(String message, Throwable cause) {
      super(message, cause);
    }

}
