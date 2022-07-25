package project_java.project.utils;

public class NoFutureTicketsFoundException extends RuntimeException{
    public NoFutureTicketsFoundException(int idCustumer) {
        super( "No history for customer with id " + idCustumer);
    }
}
