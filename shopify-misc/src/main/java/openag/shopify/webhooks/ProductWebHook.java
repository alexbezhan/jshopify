package openag.shopify.webhooks;

import openag.shopify.domain.Product;
import openag.shopify.events.ProductEvent;
import openag.shopify.spring.ShopifyPayload;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Receives changes for {@link Product} entity
 */
@RestController
@RequestMapping("/webhook/products")
public class ProductWebHook {

  private final ApplicationEventPublisher applicationEventPublisher;

  public ProductWebHook(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @PostMapping("/create")
  public void productCreated(@ShopifyPayload Product product) {
    applicationEventPublisher.publishEvent(new ProductEvent.Created(product));
  }

  @PostMapping("/update")
  public void productUpdated(@ShopifyPayload Product product) {
    applicationEventPublisher.publishEvent(new ProductEvent.Updated(product));
  }

  @PostMapping("/delete")
  public void productDeleted(@ShopifyPayload Product product) {
    applicationEventPublisher.publishEvent(new ProductEvent.Deleted(product));
  }
}
