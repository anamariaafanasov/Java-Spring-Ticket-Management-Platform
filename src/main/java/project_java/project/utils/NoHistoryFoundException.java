package project_java.project.utils;

public class NoHistoryFoundException extends RuntimeException {
    public NoHistoryFoundException(int idCustumer) {
        super( "No history for customer with id " + idCustumer);
    }
}
