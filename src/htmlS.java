import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;  
public class htmlS{  
    public static void main( String[] args ) throws Exception{  
    	//connecting to Maccabi website
    	Connection.Response loginForm = Jsoup.connect("https://online.maccabi4u.co.il/dana-na/auth/url_44/welcome.cgi").method(Connection.Method.GET).execute();
    	Document doc = Jsoup.connect("https://online.maccabi4u.co.il/dana-na/auth/url_44/login.cgi")
    			.data("cookieexists","false")
    			.data("tz_offset","")
    			.data("IDCode","0")
    			.data("username", "0-203836598")		//user id
    			.data("password","GAL323")				//password
    			.data("username1","")
    			.data("realm","Maccabi-Online")
    			.cookies(loginForm.cookies())
    			.post();
    	Document appointment = Jsoup.connect("https://online.maccabi4u.co.il/orderappointments/appointmentsorder/,DanaInfo=.aoonlrjFtilmlnvG9Pt6S26+").get();
    	System.out.println(appointment.location());
    }  
}  