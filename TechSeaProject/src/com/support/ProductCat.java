package com.support;

public class ProductCat {
	private String id;
	private String pname;
	private String pdetails;
	private String prod_parent_id;
	private String cuid;
	private String cdate;
	private String lmuid;
	private String lmdate;

	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getLmdate() {
		return lmdate;
	}
	public void setLmdate(String lmdate) {
		this.lmdate = lmdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdetails() {
		return pdetails;
	}
	public void setPdetails(String pdetails) {
		this.pdetails = pdetails;
	}


	public String getCuid() {
		return cuid;
	}
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	public String getLmuid() {
		return lmuid;
	}
	public void setLmuid(String lmuid) {
		this.lmuid = lmuid;
	}
	public String getProd_parent_id() {
		return prod_parent_id;
	}
	public void setProd_parent_id(String prod_parent_id) {
		this.prod_parent_id = prod_parent_id;
	}
}