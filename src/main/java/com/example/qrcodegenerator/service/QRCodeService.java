package com.example.qrcodegenerator.service;

public interface QRCodeService {

    byte[] generate(String text, int width, int height);

}