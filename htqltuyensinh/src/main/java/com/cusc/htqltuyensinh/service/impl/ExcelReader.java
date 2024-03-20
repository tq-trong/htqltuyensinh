package com.cusc.htqltuyensinh.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cusc.htqltuyensinh.config.Constants;
import com.cusc.htqltuyensinh.dto.UserDTO;

public class ExcelReader {
	public static List<UserDTO> readExcel(InputStream inputStream) throws IOException, ParseException {
		List<UserDTO> userDTOs = new ArrayList<>();

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);

		int subfieldStartColumnIndex = 14; // Cột bắt đầu của các ngành học nhỏ (cột N)
		int startRow = 2; // Hàng bắt đầu của dữ liệu người dùng
		Row titleSubjectRow = sheet.getRow(1); // Hàng bắt đầu của tên các ngành học

		for (int rowIndex = startRow; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			Row currentRow = sheet.getRow(rowIndex);
			if (currentRow == null) {
				continue; // Bỏ qua hàng nếu nó không tồn tại
			}

			UserDTO userDTO = new UserDTO();
			List<String> favoriteSubjects = new ArrayList<>();

			// Xử lý các thông tin cơ bản của người dùng từ cột B đến M
			userDTO.setName(getStringValue(currentRow.getCell(1)));
			userDTO.setGender(getBooleanValue(currentRow.getCell(2), "Nam"));
			userDTO.setJob(getStringValue(currentRow.getCell(3)));
			userDTO.setProvince(getStringValue(currentRow.getCell(4)).substring(0, 2));
			userDTO.setSchool(getStringValue(currentRow.getCell(5)));
			userDTO.setEmail(getStringValue(currentRow.getCell(6)));
			userDTO.setPhone(getStringValue(currentRow.getCell(7)));
			userDTO.setFatherPhone(getStringValue(currentRow.getCell(8)));
			userDTO.setMotherPhone(getStringValue(currentRow.getCell(9)));
			userDTO.setZalo(getStringValue(currentRow.getCell(10)));
			userDTO.setFacebook(getStringValue(currentRow.getCell(11)));
			userDTO.setGatherDescription(getStringValue(currentRow.getCell(12)));
			userDTO.setBirthday(getDateValue(currentRow.getCell(13)));

			// Xử lý các ngành học yêu thích từ cột N đến U
			for (int columnIndex = subfieldStartColumnIndex; columnIndex < currentRow.getLastCellNum(); columnIndex++) {
				Cell subfieldCell = currentRow.getCell(columnIndex);
				String cellValue = getStringValue(subfieldCell);
				if (subfieldCell != null) {
					if (cellValue != null && !cellValue.isEmpty()) {
						String subjectName = titleSubjectRow.getCell(columnIndex).toString();
						if (subjectName.equals("khac")) {
							userDTO.setDescriptionSubject(getStringValue(subfieldCell));
						}
						favoriteSubjects.add(subjectName);
					}
				}

			}

			userDTO.setFavoriteSubjects(favoriteSubjects);
			userDTOs.add(userDTO);
		}

		workbook.close();
		return userDTOs;
	}

	private static String getStringValue(Cell cell) {
		if (cell == null) {
			return null;
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		default:
			return null;
		}
	}

	private static boolean getBooleanValue(Cell cell, String trueString) {
		String value = getStringValue(cell);
		return value != null && value.equalsIgnoreCase(trueString);
	}

	private static Date getDateValue(Cell cell) throws ParseException {
		String stringValue = getStringValue(cell);
		if (stringValue != null) {
			return Constants.stringToDate(stringValue);
		}
		return null;
	}

	// Hàm để lấy tên cột từ chỉ số cột (0-based index)
	private static String getColumnName(int columnIndex) {
		StringBuilder columnName = new StringBuilder();
		while (columnIndex >= 0) {
			columnName.insert(0, (char) ('A' + columnIndex % 26));
			columnIndex = (columnIndex / 26) - 1;
		}
		return columnName.toString();
	}

}