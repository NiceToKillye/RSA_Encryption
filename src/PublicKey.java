import java.math.BigInteger;

public class PublicKey{
    private BigInteger n;
    private BigInteger s;

    public void setS(BigInteger s) {
        this.s = s;
    }
    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getS() {
        return s;
    }
    public BigInteger getN() { return n; }

    @Override
    public String toString(){
        return "(" + getS() + ", " + getN() + ")";
    }
}