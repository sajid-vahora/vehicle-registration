package com.vehicle.regisration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type resource not found exception
 *
 * @author sajid
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

    /**
     * Instantiate a new resource not found exception
     *
     * @param message the message
     */
    public ResourceNotFoundException(String message){
        super(message);
    }
}
