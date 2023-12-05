package Different;


public class PairKeyValueDouble<I extends Number, I1 extends Number> {
    Double key, value;

    public PairKeyValueDouble(Double key, Double value) {
        this.key = key;
        this.value = value;
    }

    public Double getKey() {
        return key;
    }

    public Double getValue() {
        return value;
    }
}