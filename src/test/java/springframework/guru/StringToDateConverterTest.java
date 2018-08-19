package springframework.guru;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class StringToDateConverterTest {
    private StringToDateConverter stringToDateConverter;

    @Before
    public void setUp() {
        stringToDateConverter = new StringToDateConverter();
    }

    @After
    public void tearDown() {
        stringToDateConverter = null;
    }

    @Test
    public void convertStringToDateTest1() throws ParseException{
        String pattern = "dd-MMM-yyyy";
        String stringToDate = "12-Mar-2018";
        Date date = stringToDateConverter.convertStringToDate(pattern,stringToDate);
        System.out.println(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String formatedDate = cal.get(Calendar.DATE) + "/" +
                (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        System.out.println("formatedDate : " + formatedDate);
        assertEquals("12/3/2018", formatedDate);
    }

    @Test
    public void convertStringToDateTest2() throws ParseException{
        String pattern = "dd/MM/yyyy";
        String stringToDate = "12/03/2018";
        Date date = stringToDateConverter.convertStringToDate(pattern,stringToDate);
        System.out.println(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String formatedDate = cal.get(Calendar.DATE) + "/" +
                (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        System.out.println("formatedDate : " + formatedDate);
        assertEquals("12/3/2018", formatedDate);
    }

    @Test
    public void convertStringToDateTest3() throws ParseException{
        String pattern = "E, MMM dd yyyy";
        String stringToDate = "Mon, March 12 2018";
        Date date = stringToDateConverter.convertStringToDate(pattern,stringToDate);
        System.out.println(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String formatedDate = cal.get(Calendar.DATE) + "/" +
                (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        System.out.println("formatedDate : " + formatedDate);
        assertEquals("12/3/2018", formatedDate);
    }

    @Test
    public void convertStringToDateTest4() throws ParseException{
        String pattern = "E, MMM dd, yyyy HH:mm:ss a";
        String stringToDate = "Monday, Mar 12, 2018 12:10:56 PM";
        Date date = stringToDateConverter.convertStringToDate(pattern,stringToDate);
        System.out.println(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String formatedDate = cal.get(Calendar.DATE) + "/" +
                (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        System.out.println("formatedDate : " + formatedDate);
        assertEquals("12/3/2018", formatedDate);
    }

    @Test
    public void convertStringToDateTest5() throws ParseException{
        String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
        String stringToDate = "2018-03-12T15:23:01Z";
        Date date = stringToDateConverter.convertStringToDateWithSuffixZ(pattern,stringToDate);
        System.out.println(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String formatedDate = cal.get(Calendar.DATE) + "/" +
                (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        System.out.println("formatedDate : " + formatedDate);
        assertEquals("12/3/2018", formatedDate);
    }

    @Test
    public void convertStringToDateTest6() throws ParseException{
        String pattern = "dd-MMM-yyyy HH:mm:ss";
        String stringToDate = "12-Mar-2018 23:37:50";
        Date date = stringToDateConverter.convertStringToDate(pattern,stringToDate);
        System.out.println(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String formatedDate = cal.get(Calendar.DATE) + "/" +
                (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        System.out.println("formatedDate : " + formatedDate);
        assertEquals("12/3/2018", formatedDate);
    }

    @Test
    public void convertStringToDateTest7() throws ParseException{
        String pattern = "dd-MMM-yyyy HH:mm:ss";
        String stringToDate = "12-Mar-2018 23:37:50";
        LocalDate date= stringToDateConverter
                .convertStringToDateWithDateTimeFormatter(pattern,stringToDate);
        System.out.println(date);
        String formatedDate = date.getDayOfMonth() + "/" +
                date.getMonthValue() + "/" + date.getYear();
        System.out.println("formatedDate : " + formatedDate);
        assertEquals("12/3/2018", formatedDate);
    }


}
