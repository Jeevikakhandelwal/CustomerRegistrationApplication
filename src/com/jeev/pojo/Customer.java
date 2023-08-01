package com.jeev.pojo;

public class Customer {

	private Integer cid;
	private String cname;
	private Integer cage;
	private String caddress;
	private Integer cmobile;
	private String cmail;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getCage() {
		return cage;
	}

	public void setCage(Integer cage) {
		this.cage = cage;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public Integer getCmobile() {
		return cmobile;
	}

	public void setCmobile(Integer cmobile) {
		this.cmobile = cmobile;
	}

	public String getCmail() {
		return cmail;
	}

	public void setCmail(String cmail) {
		this.cmail = cmail;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cage=" + cage + ", caddress=" + caddress + ", cmobile="
				+ cmobile + ", cmail=" + cmail + "]";
	}
}
