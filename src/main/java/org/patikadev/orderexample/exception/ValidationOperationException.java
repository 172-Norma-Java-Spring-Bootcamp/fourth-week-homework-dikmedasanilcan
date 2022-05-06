package org.patikadev.orderexample.exception;

public class ValidationOperationException {
    private ValidationOperationException() {
    }

    public static class CustomerNotValidException extends BaseException {
        public CustomerNotValidException(String message) {
            super(message);
        }
    }

    public static class ProductNotValidException extends BaseException {
        public ProductNotValidException(String message) {
            super(message);
        }
    }

    public static class CustomerIDNotValidException extends BaseException {
        public CustomerIDNotValidException(String message) { super(message); }
    }

    public static class ProductIDNotValidException extends BaseException {
        public ProductIDNotValidException(String message) {
            super(message);
        }
    }

    public static class CategoryNotValidException extends BaseException {
        public CategoryNotValidException(String message) {
            super(message);
        }
    }

    public static class BrandNotValidException extends BaseException {
        public BrandNotValidException(String message) {
            super(message);
        }
    }

    public static class BasketItemNotValid extends BaseException {
        public BasketItemNotValid(String message) {
            super(message);
        }
    }

    public static class BasketItemIdNotValid extends BaseException {
       public BasketItemIdNotValid(String message){ super(message);
       }
    }
}
