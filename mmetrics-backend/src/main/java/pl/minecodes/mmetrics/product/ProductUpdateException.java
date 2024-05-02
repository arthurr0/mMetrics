package pl.minecodes.mmetrics.product;

class ProductUpdateException extends RuntimeException {

  public ProductUpdateException(String message) {
    super(message);
  }

  public ProductUpdateException(String message, Throwable cause) {
    super(message, cause);
  }

}
