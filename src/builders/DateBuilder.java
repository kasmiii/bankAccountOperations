package builders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBuilder {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    public static Date date(String dateString) throws ParseException {
        return new SimpleDateFormat(DATE_FORMAT).parse(dateString);
    }

}
