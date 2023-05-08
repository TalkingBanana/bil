package com.care.back.study.dto;


public class BilStudyDto {
	private int num;
	private String title;
	private String contents;
	private String writer;
	private String writeDate;
	private int heart;
	private int view;
	private String category;
	private int comments;
	private String korCategory;
	
	public String getKorCategory() {
		return korCategory;
	}
	public void setKorCategory(String korCategory) {
		this.korCategory = korCategory;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	
}
