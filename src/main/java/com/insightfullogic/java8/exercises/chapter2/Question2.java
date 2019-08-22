package com.insightfullogic.java8.exercises.chapter2;

import java.text.SimpleDateFormat;
import javax.swing.text.DateFormatter;

public class Question2 {

	public static ThreadLocal<DateFormatter> formatter
			= ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

}
