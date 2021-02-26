/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author cristiano
 */
public class NotFoundException extends Exception{
    private String message;
    
    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
}
