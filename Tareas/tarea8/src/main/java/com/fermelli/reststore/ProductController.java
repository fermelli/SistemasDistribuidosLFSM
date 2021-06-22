package com.fermelli.reststore;

import com.fermelli.reststore.data.Product;
import com.fermelli.reststore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * Retorna toda la lista de productos
     *
     * @return lista de productos
     */
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Crea un nuevo producto en base a un formato json
     *
     * @param product
     * @return nuevo producto creado
     */
    @PostMapping(value = "/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        final Product productData = productService.create(product);
        return new ResponseEntity<>(productData, HttpStatus.CREATED);
    }

    /**
     * Devuelve informacion del producto en base a su ID
     *
     * @param id
     * @return detalles del cliente
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Remueve un producto en base a su ID proporcionado
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Actualizar los datos de un producto en base a su ID
     *
     * @param id
     * @return detalles del producto
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        product = productService.update(product, id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
