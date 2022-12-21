package com.epam.tc.hw4;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.io.InputStream;
import lombok.experimental.UtilityClass;


@UtilityClass
public class AttachmentUtils {

    public void attachmentInputStream(InputStream inputStream) {
        Allure.addAttachment("image", inputStream);
    }

    @Attachment(type = "image/png", value = "try to user param {name}")
    public byte[] makeImageAttachment(final String name, final byte[] source) {
        return source;
    }

}
