package com.fermelli.reststore.service;

import com.fermelli.reststore.dao.entity.ProductModel;
import com.fermelli.reststore.dao.entity.ProductRepository;
import com.fermelli.reststore.data.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product create(final Product product) {

        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(product, productModel);
        productModel = productRepository.save(productModel);

        Product productData = new Product();
        BeanUtils.copyProperties(productModel, productData);

        return productData;
    }

    public List<Product> getProducts() {
        
        List<ProductModel> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);

        List<Product> productList = new ArrayList<>();
        for (ProductModel productModel : products) {
            Product product = new Product();
            BeanUtils.copyProperties(productModel, product);
            productList.add(product);
        }

        return productList;
    }

    public Product getProduct(Long id) {

        Optional<ProductModel> product = productRepository.findById(id);
        Product productData = new Product();
        BeanUtils.copyProperties(product.get(), productData);

        return productData;
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Product update(final Product product, Long id) {

        Optional<ProductModel> optionalProduct = productRepository.findById(id);
        ProductModel recoveredProduct;
        if (optionalProduct.isPresent()) {
            recoveredProduct = optionalProduct.get(); //obtener directamente la clase producto
            BeanUtils.copyProperties(product, recoveredProduct);
            recoveredProduct = productRepository.save(recoveredProduct);
            return product;
        } else {
            // Avisar al usuario de que no se ha encontrado el producto
            return null;
        }
    }
    
}
