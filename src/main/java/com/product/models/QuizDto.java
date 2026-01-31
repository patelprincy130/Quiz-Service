package com.product.models;

public class QuizDto {

	private String category;
	private String title;
	private int numOfQues;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumOfQues() {
		return numOfQues;
	}
	public void setNumOfQues(int numOfQues) {
		this.numOfQues = numOfQues;
	}
	
}
