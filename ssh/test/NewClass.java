
import com.wzh.sms4.SMS4;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class NewClass {
//    public static void main2(String[] args){
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, -1);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String last_date = sdf.format(cal.getTime());
//        System.out.println(last_date);
//    }

    public static void main(String[] args) {
        String str = "10113702010000089087";
        String encodedstr = SMS4.encode(str);
        //String encodeddjxh="LHuRfnPYH/3uVrvkBd%2BOr%2B9kT1nSfK077CG2gd%2BTeO0%3D";
        String decodedstr = SMS4.decode("LHuRfnPYH/3uVrvkBd+Or+9kT1nSfK077CG2gd+TeO0%3D");
        //String decodedstr = SMS4.decode(encodedstr);
        System.out.println("encoded------------------------" + encodedstr);
        System.out.println("decoded------------------------" + decodedstr);

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<ËÄ´óÃûÖø>"
                + "	<abc id=\"x001\">11"
                + "		<a>Îâ³Ð¶÷1</a>"
                + "		<b>Îâ³Ð¶÷2</b>"
                + "		<c>Ã÷³¯</c>"
                + "	</abc>"
                + "	<dd id=\"x002\">"
                + "		<d>²ÜÑ©ÇÛ</d>"
                + "	</dd>"
                + "</ËÄ´óÃûÖø>";
        
        String xml2 =  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<ËÄ´óÃûÖø>"
                + "		<a>Îâ³Ð¶÷1</a>"
                + "		<b>Îâ³Ð¶÷2</b>"
                + "		<c>Ã÷³¯</c>"
                + "		<d>²ÜÑ©ÇÛ</d>"
                + "</ËÄ´óÃûÖø>";
        
        try {
            Document doc = DocumentHelper.parseText(xml);
            Element element = doc.getRootElement();
            Element ele = element.element("abc");
            String aa = element.elementTextTrim("a");
            String c = ele.elementTextTrim("c");
            System.out.println(c);
        } catch (DocumentException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
