package com.tencent.wxcloudrun.utils;



import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 
 * @author ruoyi
 */
public class MyStringUtils extends StringUtils
{


    /** 空字符串 */
    private static final String NULLSTR = "";

    /** 下划线 */
    private static final char SEPARATOR = '_';

    /**
     * 获取参数不为空值
     * 
     * @param value defaultValue 要判断的value
     * @return value 返回值
     */
    public static <T> T nvl(T value, T defaultValue)
    {
        return value != null ? value : defaultValue;
    }

    /**
     * * 判断一个Collection是否为空， 包含List，Set，Queue
     * 
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll)
    {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * * 判断一个Collection是否非空，包含List，Set，Queue
     * 
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll)
    {
        return !isEmpty(coll);
    }

    /**
     * * 判断一个对象数组是否为空
     * 
     * @param objects 要判断的对象数组
     ** @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects)
    {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * * 判断一个对象数组是否非空
     * 
     * @param objects 要判断的对象数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object[] objects)
    {
        return !isEmpty(objects);
    }

    /**
     * * 判断一个Map是否为空
     * 
     * @param map 要判断的Map
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Map<?, ?> map)
    {
        return isNull(map) || map.isEmpty();
    }

    /**
     * * 判断一个Map是否为空
     * 
     * @param map 要判断的Map
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Map<?, ?> map)
    {
        return !isEmpty(map);
    }

    /**
     * * 判断一个字符串是否为空串
     * 
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str)
    {
        return isNull(str) || NULLSTR.equals(str.trim())||"null".equals(str);
    }

    /**
     * * 判断一个字符串是否为非空串
     * 
     * @param str String
     * @return true：非空串 false：空串
     */
    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }

    /**
     * * 判断一个对象是否为空
     * 
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object)
    {
        return object == null;
    }

    /**
     * * 判断一个对象是否非空
     * 
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object)
    {
        return !isNull(object);
    }

    /**
     * * 判断一个对象是否是数组类型（Java基本型别的数组）
     * 
     * @param object 对象
     * @return true：是数组 false：不是数组
     */
    public static boolean isArray(Object object)
    {
        return isNotNull(object) && object.getClass().isArray();
    }

    /**
     * 去空格
     */
    public static String trim(String str)
    {
        return (str == null ? "" : str.trim());
    }

    /**
     * 截取字符串
     * 
     * @param str 字符串
     * @param start 开始
     * @return 结果
     */
    public static String substring(final String str, int start)
    {
        if (str == null)
        {
            return NULLSTR;
        }

        if (start < 0)
        {
            start = str.length() + start;
        }

        if (start < 0)
        {
            start = 0;
        }
        if (start > str.length())
        {
            return NULLSTR;
        }

        return str.substring(start);
    }

    /**
     * 截取字符串
     * 
     * @param str 字符串
     * @param start 开始
     * @param end 结束
     * @return 结果
     */
    public static String substring(final String str, int start, int end)
    {
        if (str == null)
        {
            return NULLSTR;
        }

        if (end < 0)
        {
            end = str.length() + end;
        }
        if (start < 0)
        {
            start = str.length() + start;
        }

        if (end > str.length())
        {
            end = str.length();
        }

        if (start > end)
        {
            return NULLSTR;
        }

        if (start < 0)
        {
            start = 0;
        }
        if (end < 0)
        {
            end = 0;
        }

        return str.substring(start, end);
    }


    /**
     * 下划线转驼峰命名
     */
    public static String toUnderScoreCase(String str)
    {
        if (str == null)
        {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // 前置字符是否大写
        boolean preCharIsUpperCase = true;
        // 当前字符是否大写
        boolean curreCharIsUpperCase = true;
        // 下一字符是否大写
        boolean nexteCharIsUpperCase = true;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (i > 0)
            {
                preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
            }
            else
            {
                preCharIsUpperCase = false;
            }

            curreCharIsUpperCase = Character.isUpperCase(c);

            if (i < (str.length() - 1))
            {
                nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }

            if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 是否包含字符串
     * 
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs)
    {
        if (str != null && strs != null)
        {
            for (String s : strs)
            {
                if (str.equalsIgnoreCase(trim(s)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。 例如：HELLO_WORLD->HelloWorld
     * 
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String convertToCamelCase(String name)
    {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty())
        {
            // 没必要转换
            return "";
        }
        else if (!name.contains("_"))
        {
            // 不含下划线，仅将首字母大写
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String[] camels = name.split("_");
        for (String camel : camels)
        {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty())
            {
                continue;
            }
            // 首字母大写
            result.append(camel.substring(0, 1).toUpperCase());
            result.append(camel.substring(1).toLowerCase());
        }
        return result.toString();
    }

    /**
     * 驼峰式命名法 例如：user_name->userName
     */
    public static String toCamelCase(String s)
    {
        if (s == null)
        {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if (c == SEPARATOR)
            {
                upperCase = true;
            }
            else if (upperCase)
            {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 如果target不为空返回target,否则返回一个默认值
     * @param target
     * @param defaultValue
     * @return
     */
    public static String assertNotNullOrEmpty(String target,String defaultValue){
        if(isNotEmpty(target)){
            return target;
        }else{
            return defaultValue;
        }
    }

    /**
     * 截取endStr之前的内容，包含endStr
     *
     * @param s
     * @param endStr
     * @return String
     */
    public static String trim_before(String s, String endStr) {
        int index = s.indexOf(endStr);
        int len = endStr.length();
        return index < 0 ? s : s.substring(0, index + len);
    }

    /**
     * 截取beginStr之后的内容(包含beginStr)
     *
     * @param s
     * @param beginStr
     * @return String
     */
    public static String trim_end(String s, String beginStr) {
        int index = s.indexOf(beginStr);
        return index > 0 ? s.substring(index) : s;
    }

    /**
     * 截取endStr之前的内容(不包含endStr)
     *
     * @param s
     * @param endStr
     * @return String
     */
    public static String trim_before_exclu(String s, String endStr) {
        int index = s.indexOf(endStr);
        return index < 0 ? s : s.substring(0, index);
    }

    /**
     * 截取beginStr之后的内容(不包含beginStr)
     *
     * @param s
     * @param beginStr
     * @return String
     */
    public static String trim_end_exclu(String s, String beginStr) {
        int index = s.indexOf(beginStr);
        int len = beginStr.length();
        return index > 0 ? s.substring(index + len) : s;
    }

    /**
     * 返回beginStr和endStr之间的字符串(包含)
     *
     * @param s
     * @param beginStr
     * @param endStr
     * @return String
     */
    public static String trim_mid_inclu(String s, String beginStr, String endStr) {
        s = trim_before(s, endStr);
        return trim_end(s, beginStr);
    }

    public static  String getUuid(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    /**
     * 返回beginStr和endStr之间的字符串(不包含)
     *
     * @param s
     * @param beginStr
     * @param endStr
     * @return String
     */
    public static String trim_mid_exclu(String s, String beginStr, String endStr) {
        s = trim_before_exclu(s, endStr);
        return trim_end_exclu(s, beginStr);
    }



    /**
     * 产生指定位数随机数
     * @param cout
     * @return
     */
    public static String getRandomNumberCount(int cout) {
        StringBuffer srt = new StringBuffer();
        Random random = new Random();
        for (int i=0;i<cout;i++){

            srt.append(random.nextInt(9));
        }
        return srt.toString();
    }


    /**
     * 获取请求信息中的 json字符串
     * @param request
     * @return
     */
    public static String getOpenApiRequestData(HttpServletRequest request){
//        try {
//
//            int contentLength = request.getContentLength();
//            if (contentLength < 0) {
//                return null;
//            }
//            byte buffer[] = new byte[contentLength];
//            for (int i = 0; i < contentLength;) {
//
//                int readlen = request.getInputStream().read(buffer, i, contentLength - i);
//                if (readlen == -1) {
//                    break;
//                }
//                i += readlen;
//            }
//
//            String charEncoding = request.getCharacterEncoding();
//            if (charEncoding == null) {
//                charEncoding = "UTF-8";
//            }
//            return new String(buffer, charEncoding);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;

        try {
            InputStream v_inputstream = request.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int x = 0;
            while ((x = v_inputstream.read()) != -1) {
                baos.write(x);
            }
            baos.flush();
            return new String(baos.toByteArray(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
//            logger.error(e.getMessage(), e);
        }
        return "";
    }

    /**
     * 从request中获得参数Map，并返回可读的Map
     *
     * @param request
     * @return
     */
    public static SortedMap getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        SortedMap returnMap = new TreeMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value.trim());
        }
        returnMap.remove("method");
        return returnMap;
    }


    /**
     * 产生随机的四位数
     * @return
     */
    public static String getFourRandom(){
        Random rad=new Random();
        String strRan = rad.nextInt(10000)+"";
        switch (strRan.length()) {
            case 1: strRan = "000" + strRan; break;
            case 2: strRan = "00" + strRan;  break;
            case 3: strRan = "0" + strRan;   break;
        }
        return strRan;
    }

    //过滤 xss
    public static String stripXSS(String value) {
        if (value != null) {
            Pattern scriptPattern = Pattern.compile("<script>(\\s*.*?)</script>",
                    Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("-");
            scriptPattern = Pattern.compile("</script(\\s*.*?)>",
                    Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("-");
            scriptPattern = Pattern.compile("<script(\\s*.*?)>",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("-");
            scriptPattern = Pattern.compile("eval\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("-");
            scriptPattern = Pattern.compile("e­xpression\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("-");
            scriptPattern = Pattern.compile("javascript:",
                    Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("-");
            scriptPattern = Pattern.compile("vbscript:",
                    Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("-");
            scriptPattern = Pattern.compile("onload(.*?)=",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("-");


            scriptPattern = Pattern.compile("<+.*(oncontrolselect|oncopy|oncut|ondataavailable|ondatasetchanged|ondatasetcomplete|ondblclick|ondeactivate|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop|onerror|onerroupdate|onfilterchange|onfinish|onfocus|onfocusin|onfocusout|onhelp|onkeydown|onkeypress|onkeyup|onlayoutcomplete|onload|onlosecapture|onmousedown|onmouseenter|onmouseleave|onmousemove|onmousout|onmouseover|onmouseup|onmousewheel|onmove|onmoveend|onmovestart|onabort|onactivate|onafterprint|onafterupdate|onbefore|onbeforeactivate|onbeforecopy|onbeforecut|onbeforedeactivate|onbeforeeditocus|onbeforepaste|onbeforeprint|onbeforeunload|onbeforeupdate|onblur|onbounce|oncellchange|onchange|onclick|oncontextmenu|onpaste|onpropertychange|onreadystatechange|onreset|onresize|onresizend|onresizestart|onrowenter|onrowexit|onrowsdelete|onrowsinserted|onscroll|onselect|onselectionchange|onselectstart|onstart|onstop|onsubmit|onunload)+.*=+",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("-");



            // 过滤emoji表情
            scriptPattern = Pattern
                    .compile(
                            "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
                            Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("-");
        }
        return value;
    }




    //过滤 Html
    public static String stripHtml(String value) {
        if (value != null) {
            value = value.replaceAll("iframe","");
            value = value.replaceAll("data:text/html","");
            value = value.replaceAll("data:text","");
            value = value.replaceAll("data","");
            value = value.replaceAll("src='//","");
            value = value.replaceAll("src=\"//","");
            value = value.replaceAll("src=","");
            value = value.replaceAll("src","");
            value = value.replaceAll("base64","");
            value = value.replaceAll("write","");
            value = value.replaceAll("document","");
            value = value.replaceAll("body","");
            value = value.replaceAll("createElement","");
            value = value.replaceAll("appendChild","");
        }
        return value;
    }

}