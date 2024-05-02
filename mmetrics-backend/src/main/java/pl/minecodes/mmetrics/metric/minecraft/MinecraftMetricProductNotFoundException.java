package pl.minecodes.mmetrics.metric.minecraft;

class MinecraftMetricProductNotFoundException extends RuntimeException {

  public MinecraftMetricProductNotFoundException(String message) {
    super(message);
  }

  public MinecraftMetricProductNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

}
