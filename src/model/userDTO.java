package model;


import java.sql.Timestamp;

import service.UserDAO;

public class userDTO {
	private int uNo;
	private String userID;
	private String userPW;
	private Timestamp userRegDate;
	/**
	 * @return the uNo
	 */
	public int getuNo() {
		return uNo;
	}
	/**
	 * @param uNo the uNo to set
	 */
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * @return the userPW
	 */
	public String getUserPW() {
		return userPW;
	}
	/**
	 * @param userPW the userPW to set
	 */
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	/**
	 * @return the userRegDate
	 */
	public Timestamp getUserRegDate() {
		return userRegDate;
	}
	/**
	 * @param userRegDate the userRegDate to set
	 */
	public void setUserRegDate(Timestamp userRegDate) {
		this.userRegDate = userRegDate;
	}
	@Override
	public String toString() {
		return "userDTO [uNo=" + uNo + ", userID=" + userID + ", userPW=" + userPW + ", userRegDate=" + userRegDate
				+ "]";
	}
	
 
}
