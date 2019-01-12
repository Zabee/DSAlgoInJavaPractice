package practice.concepts;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Prior to Java7, you need a Date object (a) either by new Date(); (b)
 * gregorialCalender.getTime(); if you want incemenet date, month or year Then
 * DateFormat to format date
 * 
 * @author Zabee
 *
 */
public class DateTimeDemo {

	public static void main(String[] args) {
		// Prior to Java7, you need a Date
		Date date = new Date();
		System.out.println("Date object: " + date);

		GregorianCalendar gc = new GregorianCalendar();
		gc.add(GregorianCalendar.MONTH, 2);
		gc.add(GregorianCalendar.DATE, 2);
		Date date2 = gc.getTime();
		System.out.println("\nGregorianCalendar Date object : " + date2);

		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println("\nFormatted date: " + dateFormat.format(date2));

		// JAVA8
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("\nLocalDateTime: " + ldt);

		LocalDate ld = LocalDate.of(2018, 8, 18);
		System.out.println("\nLocalDate: " + ld);

		DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("M\\d\\yyyy");
		System.out.println("\nDateTimeFormatter: " + dtformatter.format(ld));
	}
}
