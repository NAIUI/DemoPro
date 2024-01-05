package org.chainmaker.sdk;

import org.chainmaker.pb.config.ChainConfigOuterClass;
import org.chainmaker.sdk.utils.CryptoUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestAddr {

    String name = "sdsdsfdfdfd";


    @Test
    public void testNameToAddr() {
        String addr = CryptoUtils.nameToAddrStr(name, ChainConfigOuterClass.AddrType.CHAINMAKER);
        System.out.println(addr);
        String res = "b78c1c4e581637cabe2700d36093b6e5d59c0456";
        Assert.assertEquals(addr, res);
    }

    @Test
    public void testNameToAddr1() {
        String addr = CryptoUtils.nameToAddrStr(name, ChainConfigOuterClass.AddrType.ZXL);
        System.out.println(addr);
        String res = "323b16bb8e04f1b0775a622053b86a1e7567b6a6";
        Assert.assertEquals(addr, res);
    }


    @Test
    public void EVMAddress() {
        String certPem = "-----BEGIN CERTIFICATE-----\n" +
                "MIICdzCCAh6gAwIBAgIDDE8jMAoGCCqGSM49BAMCMIGKMQswCQYDVQQGEwJDTjEQ\n" +
                "MA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzEfMB0GA1UEChMWd3gt\n" +
                "b3JnMS5jaGFpbm1ha2VyLm9yZzESMBAGA1UECxMJcm9vdC1jZXJ0MSIwIAYDVQQD\n" +
                "ExljYS53eC1vcmcxLmNoYWlubWFrZXIub3JnMB4XDTIyMDgwNTA3MjMwMloXDTI3\n" +
                "MDgwNDA3MjMwMlowgZExCzAJBgNVBAYTAkNOMRAwDgYDVQQIEwdCZWlqaW5nMRAw\n" +
                "DgYDVQQHEwdCZWlqaW5nMR8wHQYDVQQKExZ3eC1vcmcxLmNoYWlubWFrZXIub3Jn\n" +
                "MQ8wDQYDVQQLEwZjbGllbnQxLDAqBgNVBAMTI2NsaWVudDEuc2lnbi53eC1vcmcx\n" +
                "LmNoYWlubWFrZXIub3JnMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE7+Szqb9f\n" +
                "7oHxobnS+D92ADt6jmDe2XglbjecXcvPJwXLeAd9FxDu/UBFoM+saQO4hvWzNCmR\n" +
                "E3lOFD7spSU9RaNqMGgwDgYDVR0PAQH/BAQDAgbAMCkGA1UdDgQiBCCu+njHmEJm\n" +
                "5j/qsEa1nHK1IF2IEu4tCKKjp5/ossJvyjArBgNVHSMEJDAigCC7A23XtvVNLr0L\n" +
                "cyi3A4jFqiOmkI7DV9VL2ShhPFZ7zzAKBggqhkjOPQQDAgNHADBEAiBtOtyOojJm\n" +
                "u1wNOCOjDiGCcPcKjtQbsma+fMqkd8nYAwIgWSXedyOvUEyO8browF+5UAwOpzjO\n" +
                "0deYCoRcxyWnJqU=\n" +
                "-----END CERTIFICATE-----";
        String pkHex = "3059301306072a8648ce3d020106082a8648ce3d03010703420004efe4b3a9bf5fee81f1a1b9d2f83f76003b7a8e60ded978256e379c5dcbcf2705cb78077d1710eefd4045a0cfac6903b886f5b334299113794e143eeca5253d45";
        String pkPem = "-----BEGIN PUBLIC KEY-----\n" +
                "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE7+Szqb9f7oHxobnS+D92ADt6jmDe\n" +
                "2XglbjecXcvPJwXLeAd9FxDu/UBFoM+saQO4hvWzNCmRE3lOFD7spSU9RQ==\n" +
                "-----END PUBLIC KEY-----";
        String privateKey = "-----BEGIN EC PRIVATE KEY-----\n" +
                "MHcCAQEEIAG7Q35sgdRJallUZ8OepYje26P6CwdckSUBccjM5g7woAoGCCqGSM49\n" +
                "AwEHoUQDQgAE7+Szqb9f7oHxobnS+D92ADt6jmDe2XglbjecXcvPJwXLeAd9FxDu\n" +
                "/UBFoM+saQO4hvWzNCmRE3lOFD7spSU9RQ==\n" +
                "-----END EC PRIVATE KEY-----";
        String hashType = "SHA256";
        String algo = "EC";
        String addr = "d111b71769c5f0178ede4c0a06af744887fda53d";
        String certAddr = CryptoUtils.getEVMAddressFromCertBytes(certPem.getBytes());
        Assert.assertEquals(certAddr, addr);
        String privatekeyAddr = CryptoUtils.getEVMAddressFromPrivateKeyBytes(privateKey.getBytes(), hashType);
        Assert.assertEquals(privatekeyAddr, addr);
        String pkHexAddr = CryptoUtils.getEVMAddressFromPKHex(pkHex, hashType, algo);
        Assert.assertEquals(pkHexAddr, addr);
        String pkpemAddr = CryptoUtils.getEVMAddressFromPKPEM(pkPem, hashType, algo);
        Assert.assertEquals(pkpemAddr, addr);
    }

    @Test
    public void ZXLAddress() {
        String certPem = "-----BEGIN CERTIFICATE-----\n" +
                "MIICzjCCAi+gAwIBAgIDCzLUMAoGCCqGSM49BAMCMGoxCzAJBgNVBAYTAkNOMRAw\n" +
                "DgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHEwdCZWlqaW5nMRAwDgYDVQQKEwd3eC1v\n" +
                "cmcxMRAwDgYDVQQLEwdyb290LWNhMRMwEQYDVQQDEwp3eC1vcmcxLWNhMB4XDTIw\n" +
                "MTAyOTEzMzgxMFoXDTMwMTAyNzEzMzgxMFowcDELMAkGA1UEBhMCQ04xEDAOBgNV\n" +
                "BAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEDAOBgNVBAoTB3d4LW9yZzEx\n" +
                "EzARBgNVBAsTCkNoYWluTWFrZXIxFjAUBgNVBAMTDXVzZXIxLnd4LW9yZzEwgZsw\n" +
                "EAYHKoZIzj0CAQYFK4EEACMDgYYABAGLEJZriYzK9Se/vMGfkwjhU55eEZsM2iKM\n" +
                "emSZICh/HY37uR0BFAVUjMYEj84tJBzEEzlpD+AUAe44/b11b+GCMwDXPKcsjHK0\n" +
                "jsAPrN5LH7uptXsjMFpN2bbOqvj6sAIDfTV9chuF91LxCjYnh+Lya0ikextGkpbp\n" +
                "HOvi5eQ/yUHSQaN7MHkwDgYDVR0PAQH/BAQDAgGmMA8GA1UdJQQIMAYGBFUdJQAw\n" +
                "KQYDVR0OBCIEIAp+6tWmoiE0KmdtpLFBZpBj1Ni7JH8g2XPgoQwhQS8qMCsGA1Ud\n" +
                "IwQkMCKAIMsnP+UWEyGuyEHBn7JkJzb+tfBqsRCBUIPyMZH4h1HPMAoGCCqGSM49\n" +
                "BAMCA4GMADCBiAJCAIENc8ip2BP4yJpj9SdR9pvZc4/qbBzKucZQaD/GT2sj0FxH\n" +
                "hp8YLjSflgw1+uWlMb/WCY60MyxZr/RRsTYpHu7FAkIBSMAVxw5RYySsf4J3bpM0\n" +
                "CpIO2ZrxkJ1Nm/FKZzMLQjp7Dm//xEMkpCbqqC6koOkRP2MKGSnEGXGfRr1QgBvr\n" +
                "8H8=\n" +
                "-----END CERTIFICATE-----";
        String pkHex = "3059301306072a8648ce3d020106082a811ccf5501822d034200044a4c24cf037b0c7a027e634b994a5fdbcd0faa718ce9053e3f75fcb9a865523a605aff92b5f99e728f51a924d4f18d5819c42f9b626bdf6eea911946efe7442d";
        String pkPem = "-----BEGIN PUBLIC KEY-----\n" +
                "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAESkwkzwN7DHoCfmNLmUpf280PqnGM\n" +
                "6QU+P3X8uahlUjpgWv+Stfmeco9RqSTU8Y1YGcQvm2Jr327qkRlG7+dELQ==\n" +
                "-----END PUBLIC KEY-----";
        String hashType = "SHA256";
        String algo = "EC";
        String certAddr = CryptoUtils.getZXAddressFromCertPEM(certPem);
        Assert.assertEquals(certAddr, "ZX0787b8affa4cbdb9994548010c80d9741113ae78");
        String pkHexAddr = CryptoUtils.getZXAddressFromPKHex(pkHex, hashType, algo);
        Assert.assertEquals(pkHexAddr, "ZXaaa6f45415493ffb832ca28faa14bef5c357f5f0");
        String pkpemAddr = CryptoUtils.getZXAddressFromPKPEM(pkPem, hashType, algo);
        Assert.assertEquals(pkpemAddr, "ZXaaa6f45415493ffb832ca28faa14bef5c357f5f0");
    }

    @Test
    public void CMAAddress() {
        String certPem = "-----BEGIN CERTIFICATE-----\n" +
                "MIICzjCCAi+gAwIBAgIDCzLUMAoGCCqGSM49BAMCMGoxCzAJBgNVBAYTAkNOMRAw\n" +
                "DgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHEwdCZWlqaW5nMRAwDgYDVQQKEwd3eC1v\n" +
                "cmcxMRAwDgYDVQQLEwdyb290LWNhMRMwEQYDVQQDEwp3eC1vcmcxLWNhMB4XDTIw\n" +
                "MTAyOTEzMzgxMFoXDTMwMTAyNzEzMzgxMFowcDELMAkGA1UEBhMCQ04xEDAOBgNV\n" +
                "BAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEDAOBgNVBAoTB3d4LW9yZzEx\n" +
                "EzARBgNVBAsTCkNoYWluTWFrZXIxFjAUBgNVBAMTDXVzZXIxLnd4LW9yZzEwgZsw\n" +
                "EAYHKoZIzj0CAQYFK4EEACMDgYYABAGLEJZriYzK9Se/vMGfkwjhU55eEZsM2iKM\n" +
                "emSZICh/HY37uR0BFAVUjMYEj84tJBzEEzlpD+AUAe44/b11b+GCMwDXPKcsjHK0\n" +
                "jsAPrN5LH7uptXsjMFpN2bbOqvj6sAIDfTV9chuF91LxCjYnh+Lya0ikextGkpbp\n" +
                "HOvi5eQ/yUHSQaN7MHkwDgYDVR0PAQH/BAQDAgGmMA8GA1UdJQQIMAYGBFUdJQAw\n" +
                "KQYDVR0OBCIEIAp+6tWmoiE0KmdtpLFBZpBj1Ni7JH8g2XPgoQwhQS8qMCsGA1Ud\n" +
                "IwQkMCKAIMsnP+UWEyGuyEHBn7JkJzb+tfBqsRCBUIPyMZH4h1HPMAoGCCqGSM49\n" +
                "BAMCA4GMADCBiAJCAIENc8ip2BP4yJpj9SdR9pvZc4/qbBzKucZQaD/GT2sj0FxH\n" +
                "hp8YLjSflgw1+uWlMb/WCY60MyxZr/RRsTYpHu7FAkIBSMAVxw5RYySsf4J3bpM0\n" +
                "CpIO2ZrxkJ1Nm/FKZzMLQjp7Dm//xEMkpCbqqC6koOkRP2MKGSnEGXGfRr1QgBvr\n" +
                "8H8=\n" +
                "-----END CERTIFICATE-----";
        String pkHex = "3059301306072a8648ce3d020106082a811ccf5501822d034200044a4c24cf037b0c7a027e634b994a5fdbcd0faa718ce9053e3f75fcb9a865523a605aff92b5f99e728f51a924d4f18d5819c42f9b626bdf6eea911946efe7442d";
        String pkPem = "-----BEGIN PUBLIC KEY-----\n" +
                "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAESkwkzwN7DHoCfmNLmUpf280PqnGM\n" +
                "6QU+P3X8uahlUjpgWv+Stfmeco9RqSTU8Y1YGcQvm2Jr327qkRlG7+dELQ==\n" +
                "-----END PUBLIC KEY-----";
        String hashType = "SHA256";
        String algo = "EC";
        String certAddr = CryptoUtils.getCMAddressFromCertPEM(certPem);
        Assert.assertEquals(certAddr, "305f98514f3c2f6fcaeb8247ed147bacf99990f8");
        String pkHexAddr = CryptoUtils.getCMAddressFromPKHex(pkHex, hashType, algo);
        Assert.assertEquals(pkHexAddr, "4cd0b5e8f6d6df38ecdc06c7431a48dd0265cb1e");
        String pkpemAddr = CryptoUtils.getCMAddressFromPKPEM(pkPem, hashType, algo);
        Assert.assertEquals(pkpemAddr, "4cd0b5e8f6d6df38ecdc06c7431a48dd0265cb1e");
    }
}
