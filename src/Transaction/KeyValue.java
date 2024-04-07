package Transaction;

import User.User;

public class KeyValue {
    User key;
    int value;

    public KeyValue(User key, int value) {
        this.key = key;
        this.value = value;
    }

    User getKey() {
        return key;
    }

    int getValue() {
        return value;
    }
}
