package letmetest.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeUtils {

	public static void main(String[] args) throws InterruptedException {
		timeutils();
	}

	public static void timeutils() throws InterruptedException {

		LocalDate lDate = LocalDate.now();
		LocalDate date2 = lDate.withDayOfMonth(10).withYear(2012);
		System.out.println("date2: " + date2);
		
		LocalDate lDate3 = LocalDate.of(2012, Month.APRIL, 5);
		System.out.println(lDate3);
		
		LocalDate lDate4 = LocalDate.parse("2015-12-25");
		System.out.println(lDate4);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDate lDate5 = LocalDate.parse("2015/12/25 12:30:30", formatter);
		System.out.println(lDate5);

		long sTime = Instant.now().toEpochMilli();
		LocalTime lStart = LocalTime.now();
		Thread.sleep(2000);
		LocalTime lEnd = LocalTime.now();
		System.out.println( Instant.now().toEpochMilli() - sTime);
		System.out.println(ChronoUnit.SECONDS.between(lStart, lEnd));
		System.out.println(ChronoUnit.MICROS.between(lStart, lEnd));
		
		
	}

}
