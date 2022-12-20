package com.epam.tc.hw4;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AttachmentUtils {

    @Attachment(type = "image/png", value = "try to user param {name}")
    public byte[] makeImageAttachment(final String name, final byte[] source) {
        return source;
    }

}
