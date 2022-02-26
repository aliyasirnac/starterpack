package nac.spring.starterpack.core.utilities.results;

public class DataResult<T> extends Result {
    private T data;


    public DataResult(boolean success, T data, String message) {
        super(success, message);
        this.data = data;
    }

    public DataResult(boolean success, T data) {
        super(success);
        this.data = data;
    }

    public DataResult(String message) {
        super(message);
    }

    public T getData() {
        return data;
    }
}
