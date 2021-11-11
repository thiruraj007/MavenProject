package org.test1;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 extends JUnitBaseClass {

	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		launch();
		setUrl("https://adactinhotelapp.com/");
		maximize();
	}

	@AfterClass
	public static void afterClass() {
		closeWindow();
	}

	@Test
	public void test() throws IOException, InterruptedException {
		WebElement txtUserName = locatorId("username");
		String userName = getData("Datas", 1, 0);
		type(txtUserName, userName);

		WebElement txtpassword = locatorId("password");
		String password = getData("Datas", 1, 1);
		type(txtpassword, password);
		WebElement btnlogin = locatorId("login");
		btnclick(btnlogin);
		WebElement dnDlocation = locatorId("location");
		String location = getData("Datas", 1, 2);
		dnDselect(dnDlocation, location);

		String hotel = getData("Datas", 1, 3);
		String roomType = getData("Datas", 1, 4);
		String noOfRooms = getData("Datas", 1, 5);
		String checkInDate = getData("Datas", 1, 6);
		String checkOut = getData("Datas", 1, 7);
		String adultPerRoom = getData("Datas", 1, 8);
		String childPerRoom = getData("Datas", 1, 9);
		WebElement dnDHotel = locatorId("hotels");
		dnDselect(dnDHotel, hotel);
		WebElement dnDRoomType = locatorId("room_type");
		dnDselect(dnDRoomType, roomType);
		WebElement dnDnosRoom = locatorId("room_nos");
		dnDselect(dnDnosRoom, noOfRooms);
		WebElement txtCheckInDate = locatorId("datepick_in");
		type(txtCheckInDate, checkInDate);
		WebElement txtCheckOut = locatorId("datepick_out");
		type(txtCheckOut, checkOut);
		WebElement dnDAdultcount = locatorId("adult_room");
		dnDselect(dnDAdultcount, adultPerRoom);
		WebElement dnDChildCount = locatorId("child_room");
		dnDselect(dnDChildCount, childPerRoom);
		WebElement btnSearch = locatorId("Submit");
		btnclick(btnSearch);
		WebElement radiobtn = locatorId("radiobutton_0");
		btnclick(radiobtn);
		WebElement btnContinue = locatorId("continue");
		btnclick(btnContinue);

		String firstNam = getData("Datas", 1, 10);
		String lastNam = getData("Datas", 1, 11);
		String billingAdd = getData("Datas", 1, 12);
		String creditNo = getData("Datas", 1, 13);
		String creditType = getData("Datas", 1, 14);
		String cardMonth = getData("Datas", 1, 15);
		String cardYear = getData("Datas", 1, 16);
		String CVV = getData("Datas", 1, 17);

		WebElement txtfirstname = locatorId("first_name");
		type(txtfirstname, firstNam);
		WebElement txtlastname = locatorId("last_name");
		type(txtlastname, lastNam);
		WebElement txtAdd = locatorId("address");
		type(txtAdd, billingAdd);
		WebElement txtCreditNo = locatorId("cc_num");
		type(txtCreditNo, creditNo);
		WebElement dnDcreditType = locatorId("cc_type");
		dnDselect(dnDcreditType, creditType);
		WebElement dnDMonth = locatorId("cc_exp_month");
		dnDselect(dnDMonth, cardMonth);
		WebElement dnDcredityear = locatorId("cc_exp_year");
		dnDselect(dnDcredityear, cardYear);

		WebElement txtCvv = locatorId("cc_cvv");
		type(txtCvv, CVV);
		WebElement btnBooknow = locatorId("book_now");
		btnclick(btnBooknow);
		Thread.sleep(5000);
		WebElement orderId = locatorId("order_no");
		String attribute = getAttribute(orderId);
		setCellValue("Datas", 1, 18, attribute);

	}

}
