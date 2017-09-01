package com.sxz.crud.bean;

public class Employee {
    private Integer empid;

    private String empname;

    private String gender;

    private String email;

    private Integer dId;
    
    private Dept dept;
    

    public Dept getDept() {
		return dept;
	}

	public Employee() {
		super();
	}

	public Employee(Integer empid, String empname, String gender, String email, Integer dId) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.gender = gender;
		this.email = email;
		this.dId = dId;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}