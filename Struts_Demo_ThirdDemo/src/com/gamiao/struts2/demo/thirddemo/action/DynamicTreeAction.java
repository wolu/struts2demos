package com.gamiao.struts2.demo.thirddemo.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.gamiao.struts2.demo.thirddemo.util.FileWrapper;
import com.opensymphony.xwork2.ActionSupport;

public class DynamicTreeAction extends ActionSupport implements ServletRequestAware {
    private static final long serialVersionUID = 1128593047269036737L;
    
    private HttpServletRequest request;
    private FileWrapper root;

    public void setServletRequest(HttpServletRequest request) {    
        this.request = request;
    }
    
    public FileWrapper getRoot() {
        return root;
    }
    
    @Override
    public String execute() {
        root = new FileWrapper(request.getSession().getServletContext().getRealPath("/"));        
        return SUCCESS;
    }
}
