/*
 * 创建日期 2005-11-10
 *
 * 更改所生成文件模板为
 * 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 */
package com.ssh.commutil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

/**
 * 
 * <p>
 * title:工具类
 * <p>
 * @company 青岛高校信息产业有限公司
 * @Copyright (c) 2005 青岛国税 All Rights Reserved.
 * @author Administrator
 * @version 1.0 2005-11-28 TODO
 */
public class CommUtils
{
	/**
	 * 验证：使用正则表达式验证生日
	 * @param str 字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkBirth(String str)
	{
		String patterns = "((19|20)[0-9]{2})-([0-9]{1,2})-([0-9]{1,2})";
		try
		{
			if (regexim(str, patterns))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 验证：使用正则表达式验证生日，支持分隔字符串
	 * @param str 字符串
	 * @param parten 分隔字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkBirth(String str, String parten)
	{
		String patterns =
			"((19|20)[0-9]{2})"
				+ parten
				+ "([0-9]{1,2})"
				+ parten
				+ "([0-9]{1,2})";
		try
		{
			if (regexim(str, patterns))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 验证：使用正则表达式验证Bp机号码
	 * @param str 字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkBp(String str)
	{
		String patterns = "([0-9])+-(0-9)+";
		try
		{
			if (regexm(str, patterns))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 验证：使用正则表达式验证email地址
	 * @param str 字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkEmail(String str)
	{
		String pattern =
			"[\\w-_]+\\@\\w+\\.[com|org|net|edu]{1}(\\.[a-z]{2}])?";
		try
		{
			if (regexic(str, pattern))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 验证：使用正则表达式验证整数
	 * @param str 字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkInteger(String str)
	{
		String patterns = "[0-9]+(.[0-9]+)?";
		try
		{
			if (regexim(str, patterns))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 验证：使用正则表达式验证手机号
	 * @param str 字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkMobile(String str)
	{
		String patterns = "(13[0-9]{9})";
		try
		{
			if (regexm(str, patterns))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 验证：使用正则表达式验证页数
	 * @param str 字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkPageNum(String str)
	{
		String patterns = "([0-9]{1,})";
		try
		{
			if (regexm(str, patterns))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 验证：使用正则表达式验证电话号码
	 * @param str 字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkPhone(String str)
	{
		String patterns = "([0-9]{3,4}-)?([1-9]{1}[0-9]{6,7})";
		try
		{
			if (regexm(str, patterns))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 验证：截取超过指定长度的文本
	 * @param strChecker 待检字符串
	 * @param strLength 最大长度
	 * @return 截取后字符串
	 * @throws Exception
	 */
	public static String checkTextArea(String strChecker, int strLength)
		throws Exception
	{
		byte[] byteArray = strChecker.getBytes();
		String newString = null;
		if (byteArray.length > 255)
		{
			if (byteArray.length > strLength)
			{
				newString = new String(byteArray, 0, strLength / 2 * 2);
			}
		}
		else
			newString = strChecker;
		return newString;
	}
	/**
	 * 验证：使用正则表达式验证时间
	 * @param str 字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkTime(String str)
	{
		String patterns =
			"((19|20)[0-9]{2})-([0-9]{1,2})-([0-9]{1,2}) ([0-2]?[0-9]{1}):([0-5]?[0-9]{1}):(([0-5]?)[0-9]{1})$";
		try
		{
			if (regexim(str, patterns))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 验证：使用正则表达式验证时间，支持分隔字符串
	 * @param str 字符串
	 * @param parten 分隔字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkTime(String str, String parten)
	{
		String patterns =
			"((19|20)[0-9]{2})"
				+ parten
				+ "([0-9]{1,2})"
				+ parten
				+ "([0-9]{1,2}) ([0-4]{1,2}):([0-5]{1,2}):([0-5]{1,2})";
		try
		{
			if (regexim(str, patterns))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 验证：使用正则表达式验证url地址
	 * @param str 字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkUrl(String str)
	{
		String patterns =
			"(http://)(www.)?([a-z0-9-]+).([a-z0-9-]+[./])([a-z0-9./]+)?";
		try
		{
			if (regexim(str, patterns))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 验证：使用正则表达式验证zip地址
	 * @param str 字符串
	 * @return true:验证成功，false:验证失败
	 */
	public static boolean checkZip(String str)
	{
		String patterns = "([1-9]{1}[0-9]{5})";
		try
		{
			if (regexm(str, patterns))
				return true;
			else
				return false;
		}
		catch (Exception err)
		{
			return false;
		}
	}
	/**
	 * 日期操作：把DATE类型转化成只含日期的字符串，支持分隔字符串
	 * @param date 待格式化日期
	 * @param parten 分隔字符串
	 * @return 格式化后日期
	 * @throws Exception
	 */
	public static String dateToString(Date date, String parten)		
	{
		String returnStr = "";
		date.toLocaleString();
		if (date != null)
		{
			if (!date.equals(""))
			{
				int year = date.getYear() + 1900;
				int month1 = date.getMonth() + 1;
				int day1 = date.getDate();
				String month = ""+month1 ;
				String day = ""+day1;
				//2006-03-04 格式化日期为加“-0”格式
				if(month1<10)
				{
					month = "0" + month1;
				}
				if(day1<10)
				{
					day = "0" + day1 ;
				}
				returnStr = year + parten + month + parten + day;
			}
		}
		return returnStr;
	}
	/**
	 * 日期操作：把DATE类型转化只含日期的字符串，支持分隔字符串
	 * @param date 待格式化日期
	 * @param parten 分隔字符串
	 * @return 格式化后日期
	 * @throws Exception
	 */
	public static String dateToString(String date, String parten)
		throws Exception
	{
		String returnValue = "";
		if (date != null)
		{
			if (!date.equals(""))
			{
				DateFormat df = DateFormat.getDateTimeInstance();
				Date dat = df.parse(date);
				returnValue = dateToString(dat, parten);
			}
		}
		return returnValue;
	}
	/**
	 * 日期操作：把DATE类型转化成包含日期时间的字符串，支持分隔字符串
	 * @param date 待格式化日期
	 * @param parten 分隔字符串
	 * @return 格式化后日期
	 * @throws Exception
	 */
	public static String timeToString(Date date, String parten)
		throws Exception
	{
		String returnStr = "";
		String month = "";
		String day = "";
		String hour = "";
		String minute = "";
		String second = "";
		if (date != null)
		{
			date.toLocaleString();
			int year = date.getYear() + 1900;
			int month1 = date.getMonth() + 1;
			if (month1 < 10)
			{
				month = "0" + month1;
			}
			else
			{
				month = String.valueOf(month1);
			}
			int day1 = date.getDate();
			if (day1 < 10)
			{
				day = "0" + day1;
			}
			else
			{
				day = String.valueOf(day1);
			}
			int hour1 = date.getHours();
			if (hour1 < 10)
			{
				hour = "0" + hour1;
			}
			else
			{
				hour = String.valueOf(hour1);
			}
			int minute1 = date.getMinutes();
			if (minute1 < 10)
			{
				minute = "0" + minute1;
			}
			else
			{
				minute = String.valueOf(minute1);
			}
			int second1 = date.getSeconds();
			if (second1 < 10)
			{
				second = "0" + second1;
			}
			else
			{
				second = String.valueOf(second1);
			}
			returnStr =
				year
					+ parten
					+ month
					+ parten
					+ day
					+ " "
					+ hour
					+ ":"
					+ minute
					+ ":"
					+ second;
		}
		return returnStr;
	}
	/**
	 * 日期操作：把DATE类型转化成包含日期时间的字符串，支持分隔字符串
	 * @param date 待格式化日期
	 * @param parten 分隔字符串
	 * @return 格式化后日期
	 * @throws Exception
	 */
	public static String timeToString(String date, String parten)
		throws Exception
	{
		String returnValue = "";
		if (date != null)
		{
			if (!date.equals(""))
			{
				DateFormat df = DateFormat.getDateTimeInstance();
				Date dat = df.parse(date);
				returnValue = timeToString(dat, parten);
			}
		}
		return returnValue;
	}
	/**
	 * 日期操作：返回当前系统时间
	 * @return 当前系统时间
	 * @throws Exception
	 */
	public static Date getToday() throws Exception
	{
		return new Date(System.currentTimeMillis());
	}
	/**
	 * 日期操作：返回当前系统时间，支持分隔字符串
	 * @return 当前系统时间
	 * @throws Exception
	 */
	public static String getTodayDate(String parten) throws Exception
	{
		Date date = new Date(System.currentTimeMillis());
		return dateToString(date, parten);
	}
	/**
	 * 日期操作：返回当前系统时间字符串
	 * @return 当前系统时间
	 * @throws Exception
	 */
	public static String getTodayTime(String parten) throws Exception
	{
		Date date = new Date(System.currentTimeMillis());
		return timeToString(date, parten);
	}
	/**
	 * 字符串操作：把字符串转换成ISO-8859-1格式
	 * @param str gb2312格式字符串
	 * @return ISO-8859-1格式字符串
	 */
	public static String chgDecoding(String str)
	{
//		if (str != null)
//		{
//			try
//			{
//				//System.out.println(str);
//				byte[] bTemp = str.getBytes("gb2312");
//				String strTemp = new String(bTemp, "ISO-8859-1");
//				//System.out.println(strTemp);
//				return strTemp;
//			}
//			catch (UnsupportedEncodingException e)
//			{
//				e.printStackTrace();
//			}
//		}
//		return "";
		return str;
	}
	/**
	 * 字符串操作：把字符串转换成gb2312格式
	 * @param str ISO-8859-1格式字符串
	 * @return gb2312格式字符串
	 */
	public static String chgEncoding(String str)
	{
//		String newStr="";
//		if (str != null){
//		try {
//			
//				
//			
//			newStr=new String(str.getBytes(),"gb2312");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//		if (str != null)
//		{
//			try
//			{
//				byte[] bTemp = str.getBytes("ISO-8859-1");
//				String strTemp = new String(bTemp, "gb2312");
//				return strTemp;
//			}
//			catch (Exception e)
//			{
//			}
//		}
//		return "";
		return str;
	}
	/**
	 * 字符串操作：去除字符串两端空格
	 * @param str 字符串
	 * @return
	 */
	public static String chgStr(String str)
	{
		if (str == null)
			return "";
		else
			return str.trim();
	}
	/**
	 * 字符串操作：判断字符串是否在字符数组中存在
	 * @param str 字符串
	 * @param arry 字符串数组
	 * @return true:存在，false：不存在
	 */
	public static boolean elementAt(String str, String[] arry)
	{
		for (int i = 0; i < arry.length; i++)
		{
			if (str.equals(arry[i]))
				return true;
		}
		return false;
	}
	/**
	 * 字符串操作：判断字符串是否在字符数组中的位置
	 * @param str 字符串
	 * @param arry 字符串数组
	 * @return 存在：返回索引号，不存在：返回-1
	 */	
	public static int elementIndexOf(String str, String[] arry)
	{
		int ret = -1;
		for (int i = 0; i < arry.length; i++)
		{
			if (str.equals(arry[i]))
			{
				ret = i;
				break;
			}
		}
		return ret;
	}
	/**
	 * 字符串操作：替换字符串内的"\n"转换成"<br>"
	 * @param str 待字符串
	 * @return 替换后字符串
	 * @throws Exception
	 */
	public static String n2br(String str) throws Exception
	{
		String ret = "";
		if (str != null)
		{
			ret = replace(str, "\n", "<br>");
			ret = replace(ret, "\r", "<br>");
		}
		return ret;
	}
	/**
	 * 字符串操作：返回字符串中子串的个数
	 * @param str 字符串
	 * @param parten 子串
	 * @return 字符串中子串的个数
	 */
	public static int partenCount(String str, String parten)
	{
		int count = 0;
		String tempStr = str;
		if (str != null && parten != null)
		{
			int indexs = -1;
			while ((indexs = tempStr.indexOf(parten, indexs + 1)) != -1)
			{
				count++;
			}
		}
		return count;
	}
	/**
	 * 字符串操作：将字符串转换为数组
	 * @param str 要转换的字符串
	 * @param parten 分隔符
	 * @return 转换后的数组
	 */
	public static String[] split(String str, String parten)
	{
		ArrayList list = new ArrayList();
		String temp = null;
		if (!str.endsWith(parten))
			temp = str + parten;
		else
			temp = str;
		while (temp.indexOf(parten) > 0)
		{
			list.add(temp.substring(0, temp.indexOf(parten)));
			temp = temp.substring(temp.indexOf(parten) + 1, temp.length());
		}
		String[] array = new String[list.size()];
		for (int i = 0; i < list.size(); i++)
		{
			array[i] = (String) list.get(i);
		}
		return array;
	}
	/**
	 * 字符串操作：字符串替换
	 * @param strSource: 原字符串
	 * @param strFrom: 要替换的字符串
	 * @param strTo: 被替换成的字符串
	 * @return 替换后的字符串
	 **/
	public static String replace(
		String strSource,
		String strFrom,
		String strTo)
	{
		if (strSource == null)
			strSource = "";
		String strDest = "";
		int intFromLen = strFrom.length();
		int intPos;
		while ((intPos = strSource.indexOf(strFrom)) != -1)
		{
			strDest = strDest + strSource.substring(0, intPos);
			strDest = strDest + strTo;
			strSource = strSource.substring(intPos + intFromLen);
		}
		strDest = strDest + strSource;
		return strDest;
	}
	/**
	 * 字符串操作：部分匹配
	 * @param str：要进行匹配的字符串
	 * @param patternStr：正则表达式
	 **/
	public static boolean regexc(String str, String patternStr)
		throws Exception
	{
		PatternCompiler compiler = new Perl5Compiler();
		Pattern pattern = compiler.compile(patternStr);
		PatternMatcher matcher = new Perl5Matcher();
		if (matcher.contains(str, pattern)) //compared with Contains method
			return true;
		else
			return false;
	}
	/**
	 * 字符串操作：大小写不敏感模式，部分匹配
	 * @param str：要进行匹配的字符串
	 * @param patternStr：正则表达式
	 **/
	public static boolean regexic(String str, String patternStr)
		throws Exception
	{
		PatternCompiler compiler = new Perl5Compiler();
		Pattern pattern =
			compiler.compile(patternStr, Perl5Compiler.CASE_INSENSITIVE_MASK);
		PatternMatcher matcher = new Perl5Matcher();
		if (matcher.contains(str, pattern)) //compared with Contains method
			return true;
		else
			return false;
	}
	/**
	 * 字符串操作：精确匹配
	 * @param str：要进行匹配的字符串
	 * @param patternStr：正则表达式
	 **/
	public static boolean regexm(String str, String patternStr)
		throws Exception
	{
		PatternCompiler compiler = new Perl5Compiler();
		Pattern pattern = compiler.compile(patternStr);
		PatternMatcher matcher = new Perl5Matcher();
		if (matcher.matches(str, pattern)) //compared with Mathes method
			return true;
		else
			return false;
	}
	/**
	 * 字符串操作：大小写不敏感模式，精确匹配
	 * @param str：要进行匹配的字符串
	 * @param patternStr：正则表达式
	 **/
	public static boolean regexim(String str, String patternStr)
		throws Exception
	{
		PatternCompiler compiler = new Perl5Compiler();
		Pattern pattern =
			compiler.compile(patternStr, Perl5Compiler.CASE_INSENSITIVE_MASK);
		PatternMatcher matcher = new Perl5Matcher();
		if (matcher.matches(str, pattern)) //compared with Mathes method
			return true;
		else
			return false;
	}
	/**
	 * 对象操作：显示对象属性
	 * @param cls 类名
	 * @param instance 对象实例
	 */
	public static void showobjfields(Object instance)
	{
		try
		{
			Method[] methods = instance.getClass().getDeclaredMethods();
			System.out.println(methods.length);
			if (instance == null)
				System.out.println("oo is null");
			for (int i = 0; i < methods.length; i++)
			{
				String mname = methods[i].getName();
				if (mname.startsWith("get"))
				{
					Object ret = null;
					if (instance != null)
						ret = methods[i].invoke(instance, new Object[0]);
 				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * 对象操作：显示request对象属性
	 * @param request request对象
	 */
	public static void showrequestattribute(HttpServletRequest request)
	{
		System.out.println("request params");
		Enumeration e = request.getAttributeNames();
		while (e.hasMoreElements())
		{
			String name = (String) e.nextElement();
			Object value = request.getAttribute(name);
			System.out.println(name + "---" + value.getClass());
		}
	}
	/**
	 * 对象操作：显示request对象参数
	 * @param request request对象
	 */
	public static void showrequestparam(HttpServletRequest request)
	{
		System.out.println("request params");
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements())
		{
			String name = (String) e.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + "---" + value);
		}
	}
	/**
	 * 对象操作：清除浏览器缓存
	 * @param response response对象
	 * @throws Exception
	 */
	public static void clearCache(HttpServletResponse response)
		throws Exception
	{
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	}

	/**
	 * 对象操作：文件后缀验证
	 * @author wangcb
	 * @param fileName:待验证文件名,带后缀全名
	 * @param extList:后缀列表,以","分隔
	 * @return boolean型
	 */
	public static boolean checkExt(String fileName , String extList)
	{
		extList.toLowerCase();
		fileName.toLowerCase();
		
		if ( extList.equals(fileName.substring(fileName.lastIndexOf(".")+1,fileName.length())) )
		{
			return true ;
		}
		
		String[] sExt = extList.split(",");
		for(int i=0 ; i<sExt.length ; i++ )
		{
			if ( sExt[i].equals(fileName.substring(fileName.lastIndexOf(".")+1,fileName.length())) )
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * 对象操作：日期格式传换:将YYYY-MM-DD或YYYYMMDD格式转换成YYYY年MM月DD日
	 * @author wangcb
	 * @param date :日期字串
	 * @return String型
	 */
	public static String getCNDate( String date )
	{
		if ( date.equals("") || date == null )
		{
			return "";
		}
		
		StringBuffer sBuf = new StringBuffer();
		if ( date.indexOf("-")==4 )	//将YYYY-MM-DD转换
		{
			sBuf.append(date.substring(0,4));
			sBuf.append("年");
			String month = date.substring(5,date.lastIndexOf("-"));
			if( month.substring(0,1).equals("0") )
			{
			    sBuf.append(month.substring(1,2));
			}
			else
			{
			    sBuf.append(month);
			}
			sBuf.append("月");
			String day = date.substring(date.lastIndexOf("-")+1);
			if( day.substring(0,1).equals("0") )
			{
			    sBuf.append(day.substring(1,2));
			}
			else
			{
			    sBuf.append(day);
			}
			sBuf.append("日");
		}
		else							//将YYYYMMDD转换
		{
			sBuf.append(date.substring(0,4));
			sBuf.append("年");
			String month = date.substring(4,6);
			if( month.substring(0,1).equals("0") )
			{
			    sBuf.append(month.substring(1,2));
			}
			else
			{
			    sBuf.append(month);
			}
			sBuf.append("月");
			String day = date.substring(6);
			if( day.substring(0,1).equals("0") )
			{
			    sBuf.append(day.substring(1,2));
			}
			else
			{
			    sBuf.append(day);
			}
			sBuf.append("日");
		}
		
		
		return sBuf.toString();
	}
	
	/**
	 * 对象操作：在一字符串按指定宽度加<br>
	 * @author wangcb
	 * @param sContent
	 * @param iLen
	 * @return String型
	 */
	public static String addBR(String sContent,int iLen)
	{
		StringBuffer sBuff = new StringBuffer();
		
		for( int i=0 ; i<sContent.length() ; i++ )
		{
			sBuff.append( sContent.charAt(i) );
			if( (i+1)%iLen == 0 )
			{
				sBuff.append("<br>");
			}
		}
		return sBuff.toString();
	}
	
	
	/**
	 * 对象操作：用来获的所提供月份的最后一天的日期
	 * @author wangcb
	 * @param String 格式为"YYYYMM"的字符串
	 * @return String:格式为“yyyyMMdd”的日期
	 */
	public static String getLastDayOfMonth( String currentDay )
	{
		String ret ="";
		int year = Integer.parseInt(currentDay.substring(0,4));
		int month = Integer.parseInt(currentDay.substring(4,6));
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,month-1,1);
		
		calendar.add( Calendar.MONTH,1 );
		calendar.add( Calendar.DATE,-1 );
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		ret = sdf.format(calendar.getTime());
		
		return ret ;
	}
	
	/**
	 * 将英文星期转换成中文，例如：Monday--星期一
	 * @author rg
	 * @param String 格式为"Monday"的字符串
	 * @return String:格式为"星期一"的日期
	 */
	public static String getDayFromEnToCn( String day )
	{
		String enDay = day.toLowerCase();
		String cnDay = day;
		java.util.Properties prop = new java.util.Properties();
		prop.put("saturday","星期六");
		prop.put("friday","星期五");
		prop.put("thursday","星期四");
		prop.put("wednesday","星期三");
		prop.put("tuesday","星期二");
		prop.put("monday","星期一");
		prop.put("sunday","星期日");
		if(prop.getProperty(enDay)!=null)
		{
			cnDay = prop.getProperty(enDay);
		}
		return cnDay ;
	}
	/**
	 * 对象操作：格式浮点数精度
	 * @author wangcb
	 * @param f:待格式化的浮点数
	 * @param pie:格式化后的精度
	 * @return float
	 */
	public static float toFloatByPie( float f ,int pie)
	{
		String s = Float.toString( f );
		for( int i=0; i<pie; i++ )
		{
			s += "0";
		}
		s = s.substring(0,s.indexOf(".")+pie+1 );
		return Float.parseFloat(s) ;
	}
	/**
	 * 对象操作：验证机构是否为市局
	 * @author wangcb
	 * @param String 税务机构代码
	 * @return 0:为市局,1:非市局
	 */
	public static int isLevel( String swjg_dm )
	{
		if( swjg_dm.substring(0,7).equals("1370200") )
		{
		    return 0 ;
		}
		return 1;
	}
	
	public static String[][] result2Array(ResultSet rs) throws SQLException
	{
		rs.last();
		String[][] result = new String[rs.getRow()][rs.getMetaData().getColumnCount()];
		
		rs.beforeFirst();
		for( int i=0; i<result.length&&rs.next(); i++ )
		{
			for( int j=0; j<result[i].length; j++ )
			{
				result[i][j] = rs.getString(j+1);
			}
		}
		return result;
	}
	
	/**
	 * 对象操作：产生一组随机数串
	 * @author rg
	 * @param int 随机数的位数
	 * @return 生成的随机数
	 */
	public static String getRandom(int bit)
	{
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ;i <bit ;i++)
		{
			sb.append(r.nextInt(10));
		}
		return sb.toString();
	}
	
	/**
	 * 对象操作：产生一组随机数串
	 * @author rg
	 * @param int 随机数的位数
	 * @return 生成的随机数
	 */
	public static String getRandom(int bit,String str)
	{
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ;i <bit ;i++)
		{
			sb.append(r.nextInt(10));
		}
		String sbstr = sb.toString();
		while(str.indexOf(sbstr)>=0)
		{
			sbstr = String.valueOf(Integer.parseInt(sb.toString())-13);
		}
		return sbstr;
	}	
	/**
	 * 对象操作：文件复制
	 * @author rg
	 * @param1 源文件名称
	 * @param2 目的文件名称
	 * @return 
	 */
	public static void copyTo(String oFile,String dFile) throws Exception
	{
		FileOutputStream fos = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try
		{
			fos = new FileOutputStream(new File(dFile)); 
			fis = new FileInputStream(new File(oFile));
			
			bis = new BufferedInputStream(fis); 
			bos = new BufferedOutputStream(fos);
			
			int c;  
			byte[]  b  =  new  byte[1024*5];
			while((c=bis.read(b))!=-1)  
			{
				bos.write(b,0,c);
			}	
		}
		catch(Exception e1) 
		{
			//throw new IntraException("error.com.gaoxiao.intraweb.commutil.copyTo","附件提取失败！");
		}
		finally
		{
			try {
				fos.close();
				fis.close();
				bos.close();
				bis.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}	
		}	
	}
	
	public static void main(String[] args)
	{
		//System.out.println(CommUtils.getDayFromEnToCn("e"));
		try{
			
			 
			System.out.println(CommUtils.getTodayTime("-"));
		//CommUtils.copyTo("D:\\upload\\ml\\123.rar","D:\\upload\\ml\\321.rar");
		}
		catch(Exception e)
		{
			
		}
	}
}
