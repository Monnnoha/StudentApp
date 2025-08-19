package model;

public class College extends Student {
	private String cname;

	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public void show() {
		System.out.println("Student Name : " + getName());
		System.out.println("Enrollment Number : " + getErp());
		System.out.println("Branch : " + getBranch());
		System.out.println("Institute : " + getInstitute());
		System.out.println("College Name : " + this.cname);
		System.out.println("");

	}
}
