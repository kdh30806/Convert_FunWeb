package com.funweb.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BoardBean {
	
	private int num;
	private String name;
	private String pass;
	private String subject;
	private String content;
	private int readcount;
	private Timestamp date;
	private String file;
	private int recommend;
	private int commentCount;
	
	
	
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");	
		return sdf.format(date);
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}

	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	
}
