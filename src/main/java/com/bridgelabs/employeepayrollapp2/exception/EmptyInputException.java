package com.bridgelabs.employeepayrollapp2.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
/**
 * @author pallavi jagtap
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmptyInputException extends RuntimeException{
    private String message;
    private String errorMessage;
}
