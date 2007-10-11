package com.gamiao.struts2.demo.thirddemo.action;

import java.util.Map;

import com.gamiao.struts2.demo.thirddemo.util.FileWrapper;
import com.googlecode.jsonplugin.JSONException;
import com.googlecode.jsonplugin.JSONUtil;

public class AjaxTreeAction extends DynamicTreeAction {
	private static final long serialVersionUID = 3970019751740942311L;

	private String action;
	private String data;
	private FileWrapper[] wrappers;

	public void setAction(String action) {
		this.action = action;
	}

	public void setData(String data) {
		this.data = data;
	}

	public FileWrapper[] getWrappers() {
		return wrappers;
	}

	@Override
	public String execute() {
		if ("getChildren".equals(action)) {
			try {
				Object o = JSONUtil.deserialize(data);
				String path = ((Map) ((Map) o).get("node")).get("objectId")
						.toString();
				wrappers = new FileWrapper(path).getChildren();
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return "ajax";
		}
		return super.execute();
	}
}
