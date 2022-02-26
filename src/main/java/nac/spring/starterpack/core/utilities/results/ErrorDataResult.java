package nac.spring.starterpack.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult(String message) {
        super(message);
    }

    public ErrorDataResult(T data, String message) {
        super(false, data, message);
    }

    public ErrorDataResult( T data) {
        super(false, data);
    }
}
