package com.zgb.exception;

import com.zgb.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2021/1/18 5:24 下午
 * @Created By guanbao.zhou
 * 异常统一处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * 参数校验:使用Precondtions
   */
  @ExceptionHandler(IllegalArgumentException.class)
  public CommonResponse handleIAException(IllegalArgumentException e) {
    log.error(e.getMessage(), e);
    return CommonResponse.error(e.getMessage());
  }

  /**
   * 方法参数校验
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public CommonResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    log.error(e.getMessage(), e);
    return CommonResponse.error(e.getBindingResult().getFieldError().getDefaultMessage());
  }

  /**
   * ValidationException
   */
  @ExceptionHandler(ValidationException.class)
  public CommonResponse handleValidationException(ValidationException e) {
    log.error(e.getMessage(), e);
    return CommonResponse.error(e.getCause().getMessage());
  }

  /**
   * ConstraintViolationException
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public CommonResponse handleConstraintViolationException(ConstraintViolationException e) {
    log.error(e.getMessage(), e);
    return CommonResponse.error(e.getMessage().split(":")[1].trim());
  }

  @ExceptionHandler(Exception.class)
  public CommonResponse handleException(Exception e) {
    log.error(e.getMessage(), e);
    log.error("【系统异常】= {}", e);
    return CommonResponse.error("系统繁忙,请稍后再试");
  }
}
