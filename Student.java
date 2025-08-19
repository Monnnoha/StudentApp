package model;

public class Student {
	private String name;
	private long erp;
	private String branch;
	private String institute;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getErp() {
		return erp;
	}
	public void setErp(long erp) {
		this.erp = erp;
	}

	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public void show() {
		System.out.println("Student Name : " + name);
		System.out.println("Enrollment Number : " + erp);
		System.out.println("Branch : " + branch);
		System.out.println("Institute : " + institute);
		System.out.println("");
	}
}
