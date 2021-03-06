package openag.shopify.events;

import openag.shopify.domain.Product;

public abstract class ProductEvent extends AbstractShopifyEvent<Product> {

  ProductEvent(Product product, String domain) {
    super(product, domain);
  }

  public Product getProduct() {
    return getTarget();
  }

  public static class Created extends ProductEvent {
    public Created(Product product) {
      super(product, null);
    }

    public Created(Product product, String domain) {
      super(product, domain);
    }
  }

  public static class Updated extends ProductEvent {
    public Updated(Product product) {
      super(product, null);
    }

    public Updated(Product product, String domain) {
      super(product, domain);
    }
  }

  public static class Deleted extends ProductEvent {
    public Deleted(Product product) {
      super(product, null);
    }

    public Deleted(Product product, String domain) {
      super(product, domain);
    }
  }

}
