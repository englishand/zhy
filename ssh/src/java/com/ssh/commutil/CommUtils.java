/*
 * �������� 2005-11-10
 *
 * �����������ļ�ģ��Ϊ
 * ���� > ��ѡ�� > Java > �������� > �����ע��
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
 * title:������
 * <p>
 * @company �ൺ��У��Ϣ��ҵ���޹�˾
 * @Copyright (c) 2005 �ൺ��˰ All Rights Reserved.
 * @author Administrator
 * @version 1.0 2005-11-28 TODO
 */
public class CommUtils
{
	/**
	 * ��֤��ʹ��������ʽ��֤����
	 * @param str �ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ��֤��ʹ��������ʽ��֤���գ�֧�ַָ��ַ���
	 * @param str �ַ���
	 * @param parten �ָ��ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ��֤��ʹ��������ʽ��֤Bp������
	 * @param str �ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ��֤��ʹ��������ʽ��֤email��ַ
	 * @param str �ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ��֤��ʹ��������ʽ��֤����
	 * @param str �ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ��֤��ʹ��������ʽ��֤�ֻ���
	 * @param str �ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ��֤��ʹ��������ʽ��֤ҳ��
	 * @param str �ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ��֤��ʹ��������ʽ��֤�绰����
	 * @param str �ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ��֤����ȡ����ָ�����ȵ��ı�
	 * @param strChecker �����ַ���
	 * @param strLength ��󳤶�
	 * @return ��ȡ���ַ���
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
	 * ��֤��ʹ��������ʽ��֤ʱ��
	 * @param str �ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ��֤��ʹ��������ʽ��֤ʱ�䣬֧�ַָ��ַ���
	 * @param str �ַ���
	 * @param parten �ָ��ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ��֤��ʹ��������ʽ��֤url��ַ
	 * @param str �ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ��֤��ʹ��������ʽ��֤zip��ַ
	 * @param str �ַ���
	 * @return true:��֤�ɹ���false:��֤ʧ��
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
	 * ���ڲ�������DATE����ת����ֻ�����ڵ��ַ�����֧�ַָ��ַ���
	 * @param date ����ʽ������
	 * @param parten �ָ��ַ���
	 * @return ��ʽ��������
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
				//2006-03-04 ��ʽ������Ϊ�ӡ�-0����ʽ
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
	 * ���ڲ�������DATE����ת��ֻ�����ڵ��ַ�����֧�ַָ��ַ���
	 * @param date ����ʽ������
	 * @param parten �ָ��ַ���
	 * @return ��ʽ��������
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
	 * ���ڲ�������DATE����ת���ɰ�������ʱ����ַ�����֧�ַָ��ַ���
	 * @param date ����ʽ������
	 * @param parten �ָ��ַ���
	 * @return ��ʽ��������
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
	 * ���ڲ�������DATE����ת���ɰ�������ʱ����ַ�����֧�ַָ��ַ���
	 * @param date ����ʽ������
	 * @param parten �ָ��ַ���
	 * @return ��ʽ��������
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
	 * ���ڲ��������ص�ǰϵͳʱ��
	 * @return ��ǰϵͳʱ��
	 * @throws Exception
	 */
	public static Date getToday() throws Exception
	{
		return new Date(System.currentTimeMillis());
	}
	/**
	 * ���ڲ��������ص�ǰϵͳʱ�䣬֧�ַָ��ַ���
	 * @return ��ǰϵͳʱ��
	 * @throws Exception
	 */
	public static String getTodayDate(String parten) throws Exception
	{
		Date date = new Date(System.currentTimeMillis());
		return dateToString(date, parten);
	}
	/**
	 * ���ڲ��������ص�ǰϵͳʱ���ַ���
	 * @return ��ǰϵͳʱ��
	 * @throws Exception
	 */
	public static String getTodayTime(String parten) throws Exception
	{
		Date date = new Date(System.currentTimeMillis());
		return timeToString(date, parten);
	}
	/**
	 * �ַ������������ַ���ת����ISO-8859-1��ʽ
	 * @param str gb2312��ʽ�ַ���
	 * @return ISO-8859-1��ʽ�ַ���
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
	 * �ַ������������ַ���ת����gb2312��ʽ
	 * @param str ISO-8859-1��ʽ�ַ���
	 * @return gb2312��ʽ�ַ���
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
	 * �ַ���������ȥ���ַ������˿ո�
	 * @param str �ַ���
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
	 * �ַ����������ж��ַ����Ƿ����ַ������д���
	 * @param str �ַ���
	 * @param arry �ַ�������
	 * @return true:���ڣ�false��������
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
	 * �ַ����������ж��ַ����Ƿ����ַ������е�λ��
	 * @param str �ַ���
	 * @param arry �ַ�������
	 * @return ���ڣ����������ţ������ڣ�����-1
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
	 * �ַ����������滻�ַ����ڵ�"\n"ת����"<br>"
	 * @param str ���ַ���
	 * @return �滻���ַ���
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
	 * �ַ��������������ַ������Ӵ��ĸ���
	 * @param str �ַ���
	 * @param parten �Ӵ�
	 * @return �ַ������Ӵ��ĸ���
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
	 * �ַ������������ַ���ת��Ϊ����
	 * @param str Ҫת�����ַ���
	 * @param parten �ָ���
	 * @return ת���������
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
	 * �ַ����������ַ����滻
	 * @param strSource: ԭ�ַ���
	 * @param strFrom: Ҫ�滻���ַ���
	 * @param strTo: ���滻�ɵ��ַ���
	 * @return �滻����ַ���
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
	 * �ַ�������������ƥ��
	 * @param str��Ҫ����ƥ����ַ���
	 * @param patternStr��������ʽ
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
	 * �ַ�����������Сд������ģʽ������ƥ��
	 * @param str��Ҫ����ƥ����ַ���
	 * @param patternStr��������ʽ
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
	 * �ַ�����������ȷƥ��
	 * @param str��Ҫ����ƥ����ַ���
	 * @param patternStr��������ʽ
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
	 * �ַ�����������Сд������ģʽ����ȷƥ��
	 * @param str��Ҫ����ƥ����ַ���
	 * @param patternStr��������ʽ
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
	 * �����������ʾ��������
	 * @param cls ����
	 * @param instance ����ʵ��
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
	 * �����������ʾrequest��������
	 * @param request request����
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
	 * �����������ʾrequest�������
	 * @param request request����
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
	 * ���������������������
	 * @param response response����
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
	 * ����������ļ���׺��֤
	 * @author wangcb
	 * @param fileName:����֤�ļ���,����׺ȫ��
	 * @param extList:��׺�б�,��","�ָ�
	 * @return boolean��
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
	 * ������������ڸ�ʽ����:��YYYY-MM-DD��YYYYMMDD��ʽת����YYYY��MM��DD��
	 * @author wangcb
	 * @param date :�����ִ�
	 * @return String��
	 */
	public static String getCNDate( String date )
	{
		if ( date.equals("") || date == null )
		{
			return "";
		}
		
		StringBuffer sBuf = new StringBuffer();
		if ( date.indexOf("-")==4 )	//��YYYY-MM-DDת��
		{
			sBuf.append(date.substring(0,4));
			sBuf.append("��");
			String month = date.substring(5,date.lastIndexOf("-"));
			if( month.substring(0,1).equals("0") )
			{
			    sBuf.append(month.substring(1,2));
			}
			else
			{
			    sBuf.append(month);
			}
			sBuf.append("��");
			String day = date.substring(date.lastIndexOf("-")+1);
			if( day.substring(0,1).equals("0") )
			{
			    sBuf.append(day.substring(1,2));
			}
			else
			{
			    sBuf.append(day);
			}
			sBuf.append("��");
		}
		else							//��YYYYMMDDת��
		{
			sBuf.append(date.substring(0,4));
			sBuf.append("��");
			String month = date.substring(4,6);
			if( month.substring(0,1).equals("0") )
			{
			    sBuf.append(month.substring(1,2));
			}
			else
			{
			    sBuf.append(month);
			}
			sBuf.append("��");
			String day = date.substring(6);
			if( day.substring(0,1).equals("0") )
			{
			    sBuf.append(day.substring(1,2));
			}
			else
			{
			    sBuf.append(day);
			}
			sBuf.append("��");
		}
		
		
		return sBuf.toString();
	}
	
	/**
	 * �����������һ�ַ�����ָ����ȼ�<br>
	 * @author wangcb
	 * @param sContent
	 * @param iLen
	 * @return String��
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
	 * �������������������ṩ�·ݵ����һ�������
	 * @author wangcb
	 * @param String ��ʽΪ"YYYYMM"���ַ���
	 * @return String:��ʽΪ��yyyyMMdd��������
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
	 * ��Ӣ������ת�������ģ����磺Monday--����һ
	 * @author rg
	 * @param String ��ʽΪ"Monday"���ַ���
	 * @return String:��ʽΪ"����һ"������
	 */
	public static String getDayFromEnToCn( String day )
	{
		String enDay = day.toLowerCase();
		String cnDay = day;
		java.util.Properties prop = new java.util.Properties();
		prop.put("saturday","������");
		prop.put("friday","������");
		prop.put("thursday","������");
		prop.put("wednesday","������");
		prop.put("tuesday","���ڶ�");
		prop.put("monday","����һ");
		prop.put("sunday","������");
		if(prop.getProperty(enDay)!=null)
		{
			cnDay = prop.getProperty(enDay);
		}
		return cnDay ;
	}
	/**
	 * �����������ʽ����������
	 * @author wangcb
	 * @param f:����ʽ���ĸ�����
	 * @param pie:��ʽ����ľ���
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
	 * �����������֤�����Ƿ�Ϊ�о�
	 * @author wangcb
	 * @param String ˰���������
	 * @return 0:Ϊ�о�,1:���о�
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
	 * �������������һ���������
	 * @author rg
	 * @param int �������λ��
	 * @return ���ɵ������
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
	 * �������������һ���������
	 * @author rg
	 * @param int �������λ��
	 * @return ���ɵ������
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
	 * ����������ļ�����
	 * @author rg
	 * @param1 Դ�ļ�����
	 * @param2 Ŀ���ļ�����
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
			//throw new IntraException("error.com.gaoxiao.intraweb.commutil.copyTo","������ȡʧ�ܣ�");
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
