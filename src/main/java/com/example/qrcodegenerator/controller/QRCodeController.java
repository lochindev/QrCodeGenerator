package com.example.qrcodegenerator.controller;

import com.example.qrcodegenerator.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class QRCodeController {

    private final int WIDTH = 250;
    private final int HEIGHT = 250;
    private final String QR_TEXT = "Izbosarov Lochinbek" +
            "Instagram : izbosarov.l --> Falow this account";

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/qr-code")
    public ResponseEntity<byte[]> getQrCode() {
        byte[] qrImage = qrCodeService.generate(QR_TEXT, WIDTH, HEIGHT);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrImage);
    }
}
