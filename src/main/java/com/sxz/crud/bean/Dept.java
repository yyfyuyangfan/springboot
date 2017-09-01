package com.sxz.crud.bean;

public class Dept {
    private Integer deptid;

    private String deptname;

    public Dept() {
		super();
	}

	public Dept(Integer deptid, String deptname) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
	}

	public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }
}