package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;

public class AttachmentUtils {

    @Attachment(type = "image/png", value = "Failed {attachmentName}")
    public static byte[] attachPngImage(String attachmentName, byte[] source) {
        return source;
    }

}

