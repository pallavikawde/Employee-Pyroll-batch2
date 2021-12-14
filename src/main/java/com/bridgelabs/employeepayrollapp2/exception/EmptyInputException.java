package com.bridgelabs.employeepayrollapp2.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
/*****************************************************************************************************************************
 *
 * @Author:PALLAVI
 * @since:8-12-21
 * @version:2.0.1
 **************************************************************************************************************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmptyInputException extends RuntimeException{
    private String message;
    private String errorMessage;
}
