package eu.isdc.employeesMng.exception;

import java.io.Serializable;

public class UserException extends Exception implements Serializable
{
    private static final long serialVersionUID = 1L;
    public UserException() {
        super();
    }
    public UserException(String msg)   {
        super(msg);
    }
    public UserException(String msg, Exception e)  {
        super(msg, e);
    }
}