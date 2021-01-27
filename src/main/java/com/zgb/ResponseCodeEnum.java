package com.zgb;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/9/17 3:12 下午
 * @Created By guanbao.zhou
 */
public enum ResponseCodeEnum {
  SUCCESS(0, "成功"),
  ERROR(-1, "错误");

  private Integer code;
  private String msg;

  public Integer getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  ResponseCodeEnum(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
