package com.ambev.test.order;

import com.ambev.test.order.dto.OrderExternalDTO;
import com.ambev.test.order.model.OrderExtProducts;
import com.ambev.test.order.model.OrderExternal;
import com.ambev.test.order.model.Product;
import com.ambev.test.order.model.Supplier;
import com.ambev.test.order.repository.OrderExtProductsRepository;
import com.ambev.test.order.repository.OrderExternalRepository;
import com.ambev.test.order.repository.SupplierRepository;
import com.ambev.test.order.service.OrderExternalService;
import com.ambev.test.order.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Set;

@Component
public class InitializationComponent {

    private static final Logger log = LoggerFactory.getLogger(InitializationComponent.class);

    @Bean
    @Order(1)
    public CommandLineRunner productsCharge(
            SupplierRepository supplierRepository,
            ProductService service) {
        return (args) -> {
            // save a few Products
            service.save(new Product("Sabão", 2.50));
            service.save(new Product("Pasta Dental", 5.00));
            service.save(new Product("Refrigerante", 10.50));
            service.save(new Product("Cerveja", 5.30));
            service.save(new Product("Shampo", 20.50));

            // fetch all Products
            log.info("Products found with findAll():");
            service.findAll().forEach(product -> {
                log.info(product.toString());
            });
            log.info("");

            // fetch an individual Product by ID
            Product product = service.findById(1L);
            log.info("Product found with findById(1L):");
            log.info(product.toString());
            log.info("");

            // fetch Product by last name
            log.info("Product found with findByName('Pasta Dental'):");
            service.findByName("Pasta Dental").forEach(product1 -> {
                log.info(product1.toString());
            });
            log.info("");
        };
    }

    @Bean
    @Order(2)
    public CommandLineRunner suppliersCharge(SupplierRepository supplierRepository) {
        return (args) -> {
            // save a few suppliers
            supplierRepository.save(new Supplier("Adidas"));
            supplierRepository.save(new Supplier("Nike"));
            supplierRepository.save(new Supplier("Procter Gamble"));

            // fetch all suppliers
            log.info("Suppliers found with findAll():");
            supplierRepository.findAll().forEach(supplier -> {
                log.info(supplier.toString());
            });
            log.info("");

            // fetch an individual Supplier by ID
            Supplier supplier = supplierRepository.findById(1L).get();
            log.info("Supplier found with findById(1L):");
            log.info(supplier.toString());
            log.info("");

            // fetch Supplier by last name
            log.info("Supplier found with findByName('Procter Gamble'):");
            supplierRepository.findByName("Procter Gamble").forEach(product1 -> {
                log.info(product1.toString());
            });
            log.info("");
        };
    }

    @Bean
    @Order(3)
    public CommandLineRunner ordersCharge(
            OrderExternalService orderExternalService,
            OrderExternalRepository orderExternalRepository,
            OrderExtProductsRepository orderExtProductsRepository,
            SupplierRepository supplierRepository,
            ProductService productService) {

        return (args) -> {

            Iterator<Supplier> suppliersIt = supplierRepository.findAll().iterator();
            Iterator<Product> productsIt = productService.findAll().iterator();

            // save a few Orders
            Supplier supplier1 = suppliersIt.next();
            Product product1 = productsIt.next();
            Product product2 = productsIt.next();
            OrderExternal orderExternal1 = new OrderExternal("Pedido 1", supplier1);
            orderExternalRepository.save(orderExternal1);
            orderExtProductsRepository.save(new OrderExtProducts(product1, orderExternal1));
            orderExtProductsRepository.save(new OrderExtProducts(product2, orderExternal1));

            OrderExternal orderExternal2 = new OrderExternal("Pedido 2", suppliersIt.next());
            orderExternalRepository.save(orderExternal2);
            orderExtProductsRepository.save(new OrderExtProducts(productsIt.next(), orderExternal2));
            orderExtProductsRepository.save(new OrderExtProducts(productsIt.next(), orderExternal2));

            OrderExternal orderExternal3 = new OrderExternal("Pedido 3", suppliersIt.next());
            orderExternalRepository.save(orderExternal3);
            orderExtProductsRepository.save(new OrderExtProducts(productsIt.next(), orderExternal3));

            OrderExternal orderExternal4 = new OrderExternal("Pedido 4", supplier1);
            orderExternalRepository.save(orderExternal4);
            orderExtProductsRepository.save(new OrderExtProducts(product2, orderExternal4));

            // fetch all Orders
            log.info("Orders found with findAll():");
            orderExternalRepository.findAll().forEach(order -> {
                log.info(order.toString());
            });
            log.info("");

            // fetch an individual Order by ID
            OrderExternal orderExternal = orderExternalRepository.findById(1L).get();
            log.info("Order found with findById(1L):");
            log.info(orderExternal.toString());
            log.info("");

            // fetch by Supplier
            log.info("Orders found from Supplier(1L):");
            Set<OrderExternalDTO> ordersExtDTO = orderExternalService.findBySupplier(1L);
            ordersExtDTO.forEach(orderExt -> {
                log.info(orderExt.toString());
            });
            log.info("");
        };
    }

}
