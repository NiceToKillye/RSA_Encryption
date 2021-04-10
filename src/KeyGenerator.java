import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {
    private static final int MAX_BIT_LENGTH = 94;

    private BigInteger privateKey;
    private final PublicKey publicKey = new PublicKey();

    private BigInteger p;
    private BigInteger q;
    private BigInteger d;

    public void generateKeys(User user){
        generatePublicKey();
        generatePrivateKey();

        user.setPublicKey(publicKey);
        user.setPrivateKey(privateKey);
    }

    private void generatePublicKey(){
        publicKey.setN(createN());
        publicKey.setS(createS());
    }

    private BigInteger createN(){
        p = BigInteger.probablePrime(75 * MAX_BIT_LENGTH / 100, new Random());
        q = BigInteger.probablePrime(25 * MAX_BIT_LENGTH / 100, new Random());
        return p.multiply(q);
    }

    private BigInteger createS() {
        d = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger s;
         do {
             s = new BigInteger(d.bitLength(), new Random());
         } while (s.compareTo(d) >= 0 || !s.gcd(d).equals(BigInteger.ONE));
        return s;
    }

    private void generatePrivateKey(){
        privateKey = publicKey.getS().modInverse(d);
    }
}