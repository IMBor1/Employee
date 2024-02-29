package Pro.Sky.Employeebook.Exception;

public class NotFoundDepartment extends NullPointerException {
    public NotFoundDepartment() {
    }

    public NotFoundDepartment(String s) {
        super(s);
    }
}