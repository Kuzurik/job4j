package ru.job4j.srp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class convert date for accounting department.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class DateFormat implements ChangeFormat{
    /**
     * this method convert date.
     * @param cel
     * @return
     */
    public String date(Calendar cel) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(cel.getTime());
    }
}
