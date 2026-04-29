package testSuite;

import groovy.json.JsonOutput;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalTimeTest {

    public static void main (String[] args){
        String time = "6:02 PM";
        //Convert 'String' type variable to LocalTime object via `.parse` by using DateTimeFormatter pattern of "h:mm a"
        //The key thing to remember is that we MUST specify the format of incoming variable value correctly, 
//      // or we will get parse exceptions
        LocalTime lt2 = LocalTime.parse(time,DateTimeFormatter.ofPattern("h:mm a",Locale.US)).plusHours(1);
        //Take the newly created LocalTime object, then format it to get the output I want (ex `hh:mm a` a for two digit hour and minutes
        System.out.println(lt2.format(DateTimeFormatter.ofPattern("hh:mm a",Locale.US)));
    }


}
