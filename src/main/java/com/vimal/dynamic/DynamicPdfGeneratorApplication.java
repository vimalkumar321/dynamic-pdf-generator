package com.vimal.dynamic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import com.vimal.dynamic.controller.PdfController;
import com.vimal.dynamic.entity.Invoice;
import com.vimal.dynamic.entity.Item;

@SpringBootApplication
public class DynamicPdfGeneratorApplication implements CommandLineRunner {

	 @Autowired
	 private PdfController pdfController;

	public static void main(String[] args) {
		SpringApplication.run(DynamicPdfGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Invoice invoice =new Invoice();
        invoice.setSeller("XYZ Pvt. Ltd.");
        invoice.setSellerGstin("29AABBCCDD121ZD");
        invoice.setSellerAddress("New Delhi, India");
        invoice.setBuyer("Vedant Computers");
        invoice.setBuyerGstin("29AABBCCDD131ZD");
        invoice.setBuyerAddress("New Delhi, India");

        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setName("Product 1");
        item.setQuantity("12 Nos");
        item.setRate(123.00);
        item.setAmount(1476.00);
        items.add(item);
        invoice.setItems(items); 

		//ByteArrayOutputStream arrayOutputStream=pdfGeneratorService.generateByteArray(invoice);
        ResponseEntity<byte[]> output=pdfController.generatePdf(invoice);
		System.out.println(output.getStatusCode());
	}

}
