package com.ateam.webstore.utilities;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
/**
 * Parse LogRecords to a single list
 * @author Brendon Drew
 *
 */
public class LogFormatter extends Formatter {
	//public static final SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss.SSS");
    @Override
    public String format(LogRecord l) {
    	String line = sd.format(new Date(l.getMillis())) + " | ";
        if (l.getSourceClassName() != null) {
            line += Utilities.padStringToLength(l.getSourceClassName().replace("com.ateam.webstore.", ""), " ", 20, false) +" | ";                     
        }
        if (l.getSourceMethodName() != null) {
            line += Utilities.padStringToLength(l.getSourceMethodName(), " ", 14, false)+" | ";                     
        }
        
		line +=  Utilities.padStringToLength(l.getLevel()+"", " ", 5, false)+" | ";
		
        line += l.getMessage();		
		
		if (l.getThrown() != null) {
			line += " | "+exception(l.getThrown());
		}
		else {
			line+=" \n";

		}
		return line;
	}
	private String exception(Throwable e) {
		String a = Arrays.toString(e.getStackTrace());
		a = a.replaceAll("\\[", "\tat ");
		a = a.replaceAll("\\]", "\n");
		a = e.getMessage()+"\n"+e.toString()+":\n"+a.replaceAll(",", "\n\tat");
		if (e.getCause() != null) {
			a+="Caused By:\n";
			try {
				a+=exception((Exception)e.getCause());				
			} catch (Exception ee) {}
		}
		return a;
	}
}