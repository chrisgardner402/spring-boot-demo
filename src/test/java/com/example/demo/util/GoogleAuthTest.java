package com.example.demo.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;
import com.google.zxing.WriterException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoogleAuthTest {

    private final String secretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";

    @Test
    public void create() throws WriterException, IOException {

        final String email = "test@gmail.com";
        final String companyName = "Awesome Company";
        final String barCodeUrl =
                GoogleAuthUtils.getGoogleAuthenticatorBarCode(secretKey, email, companyName);
        log.info(barCodeUrl);

        GoogleAuthUtils.createQRCode(barCodeUrl, "QRCode.png", 400, 400);
    }

    @Test
    public void verify() {

        final String code = "927498";
        if (code.equals(GoogleAuthUtils.getTOTPCode(secretKey))) {
            log.info("Logged in successfully");
        } else {
            log.info("Invalid 2FA Code");
        }

        Assert.assertEquals(code, GoogleAuthUtils.getTOTPCode(secretKey));
    }

    @Test
    public void randomKey() {

        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[10];
        random.nextBytes(bytes);
        log.info("bytes : {}", bytes.toString());
        try {
            String key = new String(Base64.encodeBase64(bytes, false), "UTF-8").replace("==", "");
            log.info("key : {}", key);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
