package jsg.my_project.global.response.code;

public interface BaseErrorCode {
    public ErrorReasonDto getReasonHttpStatus();
    String getMessage();
}
