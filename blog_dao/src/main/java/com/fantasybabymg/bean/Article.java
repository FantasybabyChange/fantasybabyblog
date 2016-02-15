package com.fantasybabymg.bean;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author FantasyBaby
 *
 */
public class Article implements java.io.Serializable {

	private static final long serialVersionUID = -5128387147702905248L;
	
	private String _uuid;
	private int _id;
	private String title;
	private String articleAbstract;
	private String author;
	private String publish_user;
	private String articleContent;
	private int status;
	private Category category;
	private Date createDate;
	private Date modifyDate;
	private Date publishDate;
	private List<Tag> tags;
	public Article() {
	}
	public String get_uuid() {
		return _uuid;
	}
	public void set_uuid(String _uuid) {
		this._uuid = _uuid;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticleAbstract() {
		return articleAbstract;
	}
	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish_user() {
		return publish_user;
	}
	public void setPublish_user(String publish_user) {
		this.publish_user = publish_user;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTag(List<Tag> tags) {
		this.tags = tags;
	}
}