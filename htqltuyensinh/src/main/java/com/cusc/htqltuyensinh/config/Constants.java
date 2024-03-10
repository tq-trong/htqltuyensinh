package com.cusc.htqltuyensinh.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {
	public static final  String SERVER_PORT_FRONTEND = "http://localhost:8080";
	
	// Định dạng ngày tháng trong file Excel
    private static final String EXCEL_DATE_FORMAT = "dd-MM-yyyy";

    // Chuyển đổi từ String sang Date
    public static Date stringToDate(String dateString) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(EXCEL_DATE_FORMAT);
        return dateFormat.parse(dateString);
    }
}
