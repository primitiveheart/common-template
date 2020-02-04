package com.zgb.currency;

/**
 * 货币转换关系，数字转成中文货币形式
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/1/19 2:37 下午
 * @Created By guanbao.zhou
 */
public class CurrencyUtil {
  private static final char[] CHINESE_NUM = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
  private static final char[] CHINESE_INTEGER_UNIT = {'元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿', '拾', '佰', '仟' };
  private static final char[] CHINESE_FRAGMENT_UNIT = {'里', '分', '角'};
  private static final String ZERO = "0";
  /**
   * 钱的中文式大写数字,支仅持到亿
   *
   * @throws Exception
   */
  private static String integerMoneyToChineseRMB(String moneyNum) {
    String res = "";
    int i = 0;
    int len = moneyNum.length();
    if (ZERO.equals(moneyNum)) {
      return "零元";
    }
    for (len--; len >= 0; len--) {
      res = CHINESE_INTEGER_UNIT[i++] + res;
      int num = Integer.parseInt(moneyNum.charAt(len) + "");
      res = CHINESE_NUM[num] + res;
    }
    return res.replaceAll("零[拾佰仟]", "零")
            .replaceAll("零+亿", "亿")
            .replaceAll("零+万", "万")
            .replaceAll("零+元", "元")
            .replaceAll("零+", "零");

  }

  /**
   * 整数位支持12位,到仟亿 支持到小数点后2位
   *
   * @throws Exception
   */
  public static String moneyToChineseRMB(String money) {
    String res = "";
    int i = 0;
    if (money.equals("0") || money.equals("0.0") || money.equals("0.00")) {
      return "零元";
    }
    String integerSegment = money;
    if (money.contains(".")) {
      integerSegment = money.split("\\.")[0];
      String fractionSegment = money.split("\\.")[1];
      int len = fractionSegment.length();
      for (len--; len>=0; len--) {
        int num = Integer.parseInt(fractionSegment.charAt(i++) + "");
        res += CHINESE_NUM[num];
        res += CHINESE_FRAGMENT_UNIT[len];
      }
    }
    if (res.endsWith("零")) {
      res = res.substring(0, res.length() - 1);
    }
    return integerMoneyToChineseRMB(integerSegment) + res;
  }

  public static void main(String[] args) {
    System.out.println("34".length());
    System.out.println(integerMoneyToChineseRMB("034"));;
    System.out.println(moneyToChineseRMB("344.034"));
  }
}
