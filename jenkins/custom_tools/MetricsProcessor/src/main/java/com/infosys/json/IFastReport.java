package com.infosys.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IFastReport {
	@SerializedName("totalTest")
	@Expose
	private Integer totalTest;
	@SerializedName("pass")
	@Expose
	private Integer pass;
	@SerializedName("fail")
	@Expose
	private Integer fail;

	public Integer getTotalTest() {
		return totalTest;
	}

	public void setTotalTest(Integer totalTest) {
		this.totalTest = totalTest;
	}

	public Integer getPass() {
		return pass;
	}

	public void setPass(Integer pass) {
		this.pass = pass;
	}

	public Integer getFail() {
		return fail;
	}

	public void setFail(Integer fail) {
		this.fail = fail;
	}
}
