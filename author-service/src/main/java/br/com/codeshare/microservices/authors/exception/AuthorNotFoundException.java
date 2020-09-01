package br.com.codeshare.microservices.authors.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String cause) {
        super("Author not found with " + cause);
    }
}
