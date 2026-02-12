package jsg.my_project.global.response.exception;

import jsg.my_project.global.response.code.BaseErrorCode;
import jsg.my_project.global.response.code.ErrorReasonDto;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {

    private final BaseErrorCode code;

    public GeneralException(String message, BaseErrorCode code) {
        super(message);
        this.code = code;
    }

    public GeneralException(BaseErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public ErrorReasonDto getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
    
}