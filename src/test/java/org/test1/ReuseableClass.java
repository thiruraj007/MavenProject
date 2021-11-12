package org.test1;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class ReuseableClass {
	public static void main(String[] args) throws IOException, InterruptedException {

		BaseClass cr = new BaseClass();

		cr.launch();
		cr.setUrl("https://adactinhotelapp.com/");

		WebElement txtUserName = cr.locatorId("username");
		String userName = cr.getData("Datas", 1, 0);
		cr.type(txtUserName, userName);

		WebElement txtpassword = cr.locatorId("password");
		String password = cr.getData("Datas", 1, 1);
		cr.type(txtpassword, password);
		WebElement btnlogin = cr.locatorId("login");
		cr.btnclick(btnlogin);
		WebElement dnDlocation = cr.locatorId("location");
		String location = cr.getData("Datas", 1, 2);
		cr.dnDselect(dnDlocation, location);

		String hotel = cr.getData("Datas", 1, 3);
		String roomType = cr.getData("Datas", 1, 4);
		String noOfRooms = cr.getData("Datas", 1, 5);
		String checkInDate = cr.getData("Datas", 1, 6);
		String checkOut = cr.getData("Datas", 1, 7);
		String adultPerRoom = cr.getData("Datas", 1, 8);
		String childPerRoom = cr.getData("Datas", 1, 9);
		WebElement dnDHotel = cr.locatorId("hotels");
		cr.dnDselect(dnDHotel, hotel);
		WebElement dnDRoomType = cr.locatorId("room_type");
		cr.dnDselect(dnDRoomType, roomType);
		WebElement dnDnosRoom = cr.locatorId("room_nos");
		cr.dnDselect(dnDnosRoom, noOfRooms);
		WebElement txtCheckInDate = cr.locatorId("datepick_in");
		cr.type(txtCheckInDate, checkInDate);
		WebElement txtCheckOut = cr.locatorId("datepick_out");
		cr.type(txtCheckOut, checkOut);
		WebElement dnDAdultcount = cr.locatorId("adult_room");
		cr.dnDselect(dnDAdultcount, adultPerRoom);
		WebElement dnDChildCount = cr.locatorId("child_room");
		cr.dnDselect(dnDChildCount, childPerRoom);
		WebElement btnSearch = cr.locatorId("Submit");
		cr.btnclick(btnSearch);
		WebElement radiobtn = cr.locatorId("radiobutton_0");
		cr.btnclick(radiobtn);
		WebElement btnContinue = cr.locatorId("continue");
		cr.btnclick(btnContinue);

		String firstNam = cr.getData("Datas", 1, 10);
		String lastNam = cr.getData("Datas", 1, 11);
		String billingAdd = cr.getData("Datas", 1, 12);
		String creditNo = cr.getData("Datas", 1, 13);
		String creditType = cr.getData("Datas", 1, 14);
		String cardMonth = cr.getData("Datas", 1, 15);
		String cardYear = cr.getData("Datas", 1, 16);
		String CVV = cr.getData("Datas", 1, 17);

		WebElement txtfirstname = cr.locatorId("first_name");
		cr.type(txtfirstname, firstNam);
		WebElement txtlastname = cr.locatorId("last_name");
		cr.type(txtlastname, lastNam);
		WebElement txtAdd = cr.locatorId("address");
		cr.type(txtAdd, billingAdd);
		WebElement txtCreditNo = cr.locatorId("cc_num");
		cr.type(txtCreditNo, creditNo);
		WebElement dnDcreditType = cr.locatorId("cc_type");
		cr.dnDselect(dnDcreditType, creditType);
		WebElement dnDMonth = cr.locatorId("cc_exp_month");
		cr.dnDselect(dnDMonth, cardMonth);
		WebElement dnDcredityear = cr.locatorId("cc_exp_year");
		cr.dnDselect(dnDcredityear, cardYear);

		WebElement txtCvv = cr.locatorId("cc_cvv");
		cr.type(txtCvv, CVV);
		WebElement btnBooknow = cr.locatorId("book_now");
		cr.btnclick(btnBooknow);
		Thread.sleep(5000);
		WebElement orderId = cr.locatorId("order_no");
		String attribute = cr.getAttribute(orderId);
		System.out.println(attribute);

		cr.setCellValue("Datas", 1, 18, attribute);
		cr.closeWindow();
		System.out.println("confilcts 1");
		System.out.println("Final A");

	}

}
