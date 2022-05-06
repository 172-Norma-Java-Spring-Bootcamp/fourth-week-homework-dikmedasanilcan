package org.patikadev.orderexample.exception;

public class BusinessServiceOperationException {
    private BusinessServiceOperationException() {
    }

    public static class CustomerNotFoundException extends BaseException {
        public CustomerNotFoundException(String message) {
            super(message);
        }
    }

    public static class CustomerAlreadyDeletedException extends BaseException {
        public CustomerAlreadyDeletedException(String message) {
            super(message);
        }
    }
    public static class ProductNotFoundException extends BaseException{
        public ProductNotFoundException(String message) {super(message);}
    }

    public static class ProductAlreadyDeletedException extends BaseException{
        public ProductAlreadyDeletedException(String message) {super(message);}
    }

    public static class CategoryNotFoundException extends BaseException{
        public CategoryNotFoundException(String message) {super(message);}
    }

    public static class BrandNotFoundException extends BaseException{
        public BrandNotFoundException(String message) {super(message);}
    }

    public static class BrandAlreadyHave extends BaseException{
        public BrandAlreadyHave(String message){super(message);}
    }

    public static class CategoryAlreadyHave extends BaseException{
        public CategoryAlreadyHave(String message){super(message);}
    }

    public static class CustomerAlreadyHaveException extends BaseException {
        public CustomerAlreadyHaveException(String message) {
            super(message);
        }
    }

    public static class CustomerPhoneAlreadyHaveException extends BaseException {
        public CustomerPhoneAlreadyHaveException(String message) {
            super(message);
        }
    }

    public static class ProductAlreadyHaveException extends BaseException {
        public ProductAlreadyHaveException(String message) {
            super(message);
        }
    }

    public static class BasketNotFoundException extends BaseException {
        public BasketNotFoundException(String message) {
            super(message);
        }
    }

    public static class BasketItemNotFound extends BaseException {
        public BasketItemNotFound(String message) {
            super(message);
        }
    }
}
