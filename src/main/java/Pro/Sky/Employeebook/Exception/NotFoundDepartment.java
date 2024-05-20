package Pro.Sky.Employeebook.Exception;

public class NotFoundDepartment extends RuntimeException {
    public NotFoundDepartment() {
    }

    public NotFoundDepartment(String message) {
        super(message);
    }

    public NotFoundDepartment(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundDepartment(Throwable cause) {
        super(cause);
    }

    public NotFoundDepartment(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
