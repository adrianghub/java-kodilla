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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    public static final String FIRST_PRODUCT_NAME = "Bathroom accessories";
    public static final String FIRST_ITEM_DESCRIPTION = "Rubber Duck";
    public static final String SECOND_ITEM_DESCRIPTION = "Soap";
    public static final String THIRD_ITEM_DESCRIPTION = "Sponge Bob";
    public static final String INVOICE_HEADER_NAME = "LP131131/32N/20";

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testSaveProductWithItems() {
        //Given
        Product product = new Product(FIRST_PRODUCT_NAME);

        Item item = new Item(new BigDecimal(100), 5, FIRST_ITEM_DESCRIPTION);
        Item item2 = new Item(new BigDecimal(200), 6, SECOND_ITEM_DESCRIPTION);
        Item item3 = new Item(new BigDecimal(300), 7, THIRD_ITEM_DESCRIPTION);

        product.addItem(item);
        product.addItem(item2);
        product.addItem(item3);

        //When
        productDao.save(product);
        int id = product.getId();

        //Then
        assertEquals(3, product.getItems().size());

        //CleanUp
        productDao.deleteById(id);
    }

    @Test
    void testFindItemsByPrice() {
        //Given
        Product product = new Product(FIRST_PRODUCT_NAME);

        Item item = new Item(new BigDecimal(100), 5, FIRST_ITEM_DESCRIPTION);
        Item item2 = new Item(new BigDecimal(200), 6, SECOND_ITEM_DESCRIPTION);
        Item item3 = new Item(new BigDecimal(300), 6, THIRD_ITEM_DESCRIPTION);

        product.addItem(item);
        product.addItem(item2);
        product.addItem(item3);

        //When
        productDao.save(product);
        int id = product.getId();

        List<Item> result = itemDao.findByQuantity(6);

        //Then
        assertEquals(2, result.size());

        //CleanUp
        productDao.deleteById(id);
    }

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product = new Product(FIRST_PRODUCT_NAME);

        Item item = new Item(new BigDecimal(100), 5, FIRST_ITEM_DESCRIPTION);
        Item item2 = new Item(new BigDecimal(200), 6, SECOND_ITEM_DESCRIPTION);
        Item item3 = new Item(new BigDecimal(300), 7, THIRD_ITEM_DESCRIPTION);

        Invoice invoice = new Invoice(INVOICE_HEADER_NAME);
        invoice.addItem(item);
        invoice.addItem(item2);
        invoice.addItem(item3);

        //When
        productDao.save(product);
        int productId = product.getId();
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();


        try {
            //Then
            assertNotEquals(0, invoiceId);
        } finally {
            //CleanUp
            productDao.deleteById(productId);
            invoiceDao.deleteById(invoiceId);
        }
    }
}
