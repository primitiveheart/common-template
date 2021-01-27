package com.zgb;


/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/12/28 3:08 下午
 * @Created By guanbao.zhou
 */
public class CommonResponse<T> {
  /**
   * 状态码
   **/
  private Integer code;
  /**
   * 消息
   **/
  private String msg;
  /**
   * 数据
   */
  private T data;


  public static CommonResponse error(String msg) {
    CommonResponse response = new CommonResponse();
    response.setMsg(msg);
    response.setCode(ResponseCodeEnum.ERROR.getCode());
    return response;
  }

  public static CommonResponse error(String msg, Integer code) {
    CommonResponse response = new CommonResponse();
    response.setMsg(msg);
    response.setCode(code);
    return response;
  }

  public static <T> CommonResponse success(Integer code, String msg, T data) {
    CommonResponse response = new CommonResponse();
    response.setMsg(msg);
    response.setCode(code);
    response.setData(data);
    return response;
  }

  public static <T> CommonResponse success(String msg, T data) {
    CommonResponse response = new CommonResponse();
    response.setData(data);
    response.setCode(ResponseCodeEnum.SUCCESS.getCode());
    response.setMsg(msg);
    return response;
  }

  public static <T> CommonResponse success(T data) {
    CommonResponse response = new CommonResponse();
    response.setData(data);
    response.setCode(ResponseCodeEnum.SUCCESS.getCode());
    return response;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
