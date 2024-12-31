package com.peronal.project.ecomApp.ecomPrj.advices;

import com.peronal.project.ecomApp.ecomPrj.controllers.ProductController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = ProductController.class)
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<String> handleIndexOutOfBoundException(){
        //Debug this to log but just give "Something went wrong" to user
        System.out.println("Index out of bounds");
        return new ResponseEntity<>("Something ent Wrong", HttpStatus.NOT_FOUND);
    }
}
