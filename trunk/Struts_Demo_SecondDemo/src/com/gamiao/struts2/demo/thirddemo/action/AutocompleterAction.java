package com.gamiao.struts2.demo.thirddemo.action;

import java.util.ArrayList;
import java.util.List;

import com.gamiao.struts2.demo.thirddemo.util.Datas;
import com.opensymphony.xwork2.ActionSupport;

public class AutocompleterAction extends ActionSupport {
	private static final long serialVersionUID = -8201401726773589361L;

	private List<String[]> names;
	private String start;

	public void setStart(String start) {
		this.start = start;
	}

	public List<String[]> getNames() {
		return names;
	}

	@Override
	public String execute() {
		names = new ArrayList<String[]>();
		if (start == null || "".equals(start.trim())) {
			start = "a";
		}
		for (String s : Datas.NAMES) {
			if (s.toLowerCase().startsWith(start.toLowerCase())) {
				names.add(new String[] { s, s });
			}
		}
		return SUCCESS;
	}
}
