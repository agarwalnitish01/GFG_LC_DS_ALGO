package Different;


public class PairKeyValueInteger<I extends Number, I1 extends Number> {
    Integer key, value;

    public PairKeyValueInteger(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
}