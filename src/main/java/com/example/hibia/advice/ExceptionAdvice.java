package com.example.hibia.advice;

import com.example.hibia.advice.exception.*;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private final ResponseService responseService;
    private final MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("unKnown.code")), getMessage("unKnown.msg"));
    }

    @ExceptionHandler(CUserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(HttpServletRequest request, CUserNotFoundException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("userNotFound.code")), getMessage("userNotFound.msg"));
    }

    @ExceptionHandler(CEmailSigninFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult emailSigninFailedException(HttpServletRequest request, CEmailSigninFailedException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("emailSigninFailed.code")), getMessage("emailSigninFailed.msg"));
    }

    @ExceptionHandler(CAuthenticationEntryPointException.class)
    public CommonResult authenticationEntryPointException(HttpServletRequest request, CAuthenticationEntryPointException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("entryPointException.code")), getMessage("entryPointException.msg"));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public CommonResult accessDeniedException(HttpServletRequest request, AccessDeniedException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("accessDenied.code")), getMessage("accessDenied.msg"));
    }

    @ExceptionHandler(CNotOwnerException.class)
    @ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
    public CommonResult notOwnerException(HttpServletRequest request, CNotOwnerException e){
        return responseService.getFailResult(Integer.valueOf(getMessage("notOwnerException.code")),getMessage("notOwnerException.msg"));
    }

    @ExceptionHandler(CResourceNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonResult resourceNotExistException(HttpServletRequest request, CResourceNotExistException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("resourceNotExist.code")), getMessage("resourceNotExist.msg"));
    }

    @ExceptionHandler(CCartItemExistException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult cartItemExistException(HttpServletRequest request, CCartItemExistException e){
        return responseService.getFailResult(Integer.valueOf(getMessage("cartItemAlreadyExist.code")),getMessage("cartItemAlreadyExist.msg"));
    }

    private String getMessage(String code){
        return getMessage(code, null);
    }

    private String getMessage(String code, Object[] args){
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

}