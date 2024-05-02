package pl.minecodes.mmetrics.product;

class ProductCreationException extends RuntimeException {

  public ProductCreationException(String message) {
    super(message);
  }

  public ProductCreationException(String message, Throwable cause) {
    super(message, cause);
  }

}
