import java.math.BigInteger;

public class User {

    private BigInteger privateKey;
    private final PublicKey publicKey = new PublicKey();

    public User(){
        KeyGenerator generator = new KeyGenerator();
        generator.generateKeys(this);
    }

    public String encode(String stringToEncode, PublicKey publicKey){
        String encoded = "";
        byte[] bytes = stringToEncode.getBytes();

        for (byte singleByte: bytes){
            BigInteger integer = new BigInteger(String.valueOf(singleByte));
            encoded = encoded.concat(integer.modPow(publicKey.getS(), publicKey.getN()).toString() + " ");
        }

        return encoded;
    }

    public String decode(String encodedString){
        String[] strings = encodedString.split(" ");
        byte[] bytes = new byte[strings.length];

        for(int i = 0; i < strings.length; i++){
            BigInteger integer = new BigInteger(strings[i]);
            bytes[i] = integer.modPow(privateKey, publicKey.getN()).byteValueExact();
        }

        return new String(bytes);
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey.setN(publicKey.getN());
        this.publicKey.setS(publicKey.getS());
    }

    public void setPrivateKey(BigInteger privateKey) {
        this.privateKey = privateKey;
    }

}