package Pro.Sky.Employeebook.Exception;

public class DepartmentIsEmpty extends NullPointerException {
    public DepartmentIsEmpty() {
    }

    public DepartmentIsEmpty(String s) {
        super(s);
    }
}