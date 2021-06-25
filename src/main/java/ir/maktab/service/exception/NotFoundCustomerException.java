package ir.maktab.service.exception;

public class NotFoundCustomerException extends Exception {
    public NotFoundCustomerException(String ma) {
        super(ma);
    }
}
