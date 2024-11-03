package com.vimal.dynamic.service;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.vimal.dynamic.entity.Invoice;

public interface PdfGeneratorService {
	ByteArrayOutputStream generateByteArray(Invoice invoice);
}
