package baidu.giftshop.util;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringUtil {
    public static final String getTagContent(String wholeContent, String startTag, String endTag) {
        final int startIndex = wholeContent.indexOf(startTag);
        if (startIndex < 0)
            return null;
        final int endIndex = wholeContent.indexOf(endTag);
        if (endIndex <= 0 || endIndex < startIndex + startTag.length())
            return null;
        return wholeContent.substring(startIndex + startTag.length(), endIndex);
    }

    /**
     * 判断字符串是否为空
     * 
     * 
     * @param str
     *            被判断对象
     * @Return:
     */
    public static boolean isNotEmpty(String... str) {
        int length = str.length;
        for (int i = 0; i < length; i++) {
            if (str[i] != null && !"".equals(str[i].trim())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串为null返回""
     * 
     * @Author: zhouyu
     * @CreateDate: 2012-09-16
     * @param str
     *            被判断对象
     * @Return:
     */
    public static String isNotEmptybyStr(String str) {
        if (str != null && !"".equals(str.trim()) && !"null".equals(str) && !"0".equals(str)) {
        } else {
            return "";
        }
        return str;
    }

    /**
     * 验证手机号码的合法性
     * 
     * @param mobilePhone
     * @return
     */
    public static boolean checkMobliePhone(String mobilePhone) {
        if (!isNotEmpty(mobilePhone)) {
            return false;
        }
        Pattern p = Pattern.compile("^((13[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobilePhone);
        return m.matches();
    }

    /**
     * 比较版本号
     * 
     * @param ver
     *            版本号
     * @param anotherVer
     *            比较的版本号
     */
    public static int compareVer(String ver, String anotherVer) {
        // 0：相等；1：大于；-1：小于
        String[] bigArr = ver.split("\\.");
        String[] smallArr = anotherVer.split("\\.");
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(bigArr[i]) > Integer.parseInt(smallArr[i])) {
                return 1;
            } else if (Integer.parseInt(bigArr[i]) < Integer.parseInt(smallArr[i])) {
                return -1;
            }
        }
        return 0;
    }

    public static boolean inVersionRange(String ver, String verRangeConfig) {
        String[] config = verRangeConfig.split(",");
        if (config.length != 2)
            return false;

        boolean matchSmall = false, matchBig = false;
        String configVer = config[0].substring(1);
        if (config[0].startsWith("[") && compareVer(ver, configVer) >= 0) {
            matchSmall = true;
        } else if (config[0].startsWith("(") && compareVer(ver, configVer) > 0) {
            matchSmall = true;
        }
        configVer = config[1].substring(0, config[1].length() - 1);
        if ("oo".equals(configVer)) {
            matchBig = true;
        } else if (config[1].endsWith("]") && compareVer(ver, configVer) <= 0) {
            matchBig = true;
        } else if (config[1].endsWith(")") && compareVer(ver, configVer) < 0) {
            matchBig = true;
        }

        if (matchSmall && matchBig) {
            return true;
        }
        return false;
    }

    public static final String buildParams(Map<String, String> params, String start, String end, boolean sort, boolean encode) {

        ArrayList<String> keys = new ArrayList<String>(params.keySet());
        if (sort) {
            Collections.sort(keys); // 参数排序
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (value == null || value.length() == 0)
                continue;

            if (encode) {
                try {
                    value = URLEncoder.encode(value, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                }
            }

            sb.append(key).append("=");
            if (start != null && end != null) {
                sb.append(start).append(value).append(end);
            } else {
                sb.append(value);
            }
            if (i < keys.size() - 1) {// 拼接时，不包括最后一个&字符
                sb.append("&");
            }
        }

        return sb.toString();
    }

    public static final String buildParams(Map<String, String> params, boolean sort, boolean encode) {
        return buildParams(params, null, null, sort, encode);
    }

    /**
     * 截掉小数
     * 
     * @Author: wangfeng
     * @CreateDate: 2014-07-18
     * @param str
     *            被判断对象
     * @Return:
     */
    public static String cutOffDecimal(String str) {
        if (str != null && !"".equals(str.trim()) && !"null".equals(str) && !"0".equals(str)) {
            if (str.indexOf(".") > 0) {
                str = str.substring(0, str.indexOf("."));
            }
        }
        return str;
    }

    /**
     * 过滤特殊字符
     * 
     * @param str
     * @return
     */
    public static String StringFilter(String str) throws PatternSyntaxException {
        String regEx = "[`~!@#$%^&*()+=|{}';',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

}
