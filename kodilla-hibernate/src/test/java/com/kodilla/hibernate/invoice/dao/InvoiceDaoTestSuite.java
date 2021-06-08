package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    public static final String FIRST_PRODUCT_NAME = "Rubber Duck";
    public static final String SEC_PRODUCT_NAME = "Luksja Soap";
    public static final String THIRD_PRODUCT_NAME = "Sponge Bob";
    public static final String INVOICE_HEADER_NAME = "LP131131/32N/20";

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testSaveProductDao() {
        //Given
        Product product = new Product(FIRST_PRODUCT_NAME);
        productDao.save(product);
        int id = product.getId();

        //When
        Optional<Product> result = productDao.findById(id);

        //Then
        assertTrue(result.isPresent());

        //CleanUp
        productDao.deleteById(id);
    }

    @Test
    void testSaveItemDao() {
        //Given
        Item item = new Item(new BigDecimal(300), 5, new BigDecimal(10));
        item.setProduct(new Product(FIRST_PRODUCT_NAME));

        //When
        itemDao.save(item);
        int id = item.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        itemDao.deleteById(id);
    }

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product = new Product(FIRST_PRODUCT_NAME);
        Product product2 = new Product(SEC_PRODUCT_NAME);
        Product product3 = new Product(THIRD_PRODUCT_NAME);

        Item item = new Item(new BigDecimal(100), 5, new BigDecimal(10));
        Item item2 = new Item(new BigDecimal(200), 6, new BigDecimal(20));
        Item item3 = new Item(new BigDecimal(300), 7, new BigDecimal(30));
        Item item4 = new Item(new BigDecimal(400), 8, new BigDecimal(40));

        item.setProduct(product);
        item2.setProduct(product3);
        item3.setProduct(product);
        item4.setProduct(product2);

        Invoice invoice = new Invoice(INVOICE_HEADER_NAME);
        invoice.getItems().add(item);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0, invoiceId);

        //CleanUp
        try {
            invoiceDao.deleteById(invoiceId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
