package springframework.guru;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StringToDateConverter {

    public Date convertStringToDate(String pattern, String dateInString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (dateInString == null) {
            throw new ParseException("String cannot be parsed", 0);
        } else {
            Date date = simpleDateFormat.parse(dateInString);
            return date;
        }
    }

    public Date convertStringToDateWithSuffixZ(String pattern, String dateInString)
            throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (dateInString == null) {
            throw new ParseException("String cannot be parsed", 0);
        } else {
            Date date = simpleDateFormat.parse(dateInString
                    .replaceAll("Z$","+0000"));
            return date;
        }
    }

    public LocalDate convertStringToDateWithDateTimeFormatter(String pattern,
                                                              String dateInString) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate = LocalDate.parse(dateInString, dateTimeFormatter);
        return localDate;
    }
}
