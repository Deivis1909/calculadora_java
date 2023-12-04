package com.BeerRevoluiton.calculadoraJava.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date timesTemp;
    private String message;

    private String details;

    public Date getTimesTemp() {
        return timesTemp;
    }

    public void setTimesTemp(Date timesTemp) {
        this.timesTemp = timesTemp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ExceptionResponse(Date timesTemp, String message, String details) {
        this.message = message;
        this.timesTemp = timesTemp;
        this.details = details;

    }
}
