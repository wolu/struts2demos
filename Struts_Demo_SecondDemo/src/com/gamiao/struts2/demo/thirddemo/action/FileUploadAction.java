package com.gamiao.struts2.demo.thirddemo.action;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FileUploadAction.class);

	private static final long serialVersionUID = 572146812454l;
	private static final int BUFFER_SIZE = 16 * 1024;

	private File myFile;
	private String contentType;
	private String fileName;
	private String imageFileName;
	private String caption;

	public void setMyFileContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setMyFileFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	private static void copy(File src, File dst) {
		if (logger.isDebugEnabled()) {
			logger.debug("copy(File, File) - start"); //$NON-NLS-1$
		}

		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			logger.error("copy(File, File)", e); //$NON-NLS-1$

			e.printStackTrace();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("copy(File, File) - end"); //$NON-NLS-1$
		}
	}

	private static String getExtention(String fileName) {
		if (logger.isDebugEnabled()) {
			logger.debug("getExtention(String) - start"); //$NON-NLS-1$
		}

		int pos = fileName.lastIndexOf(".");
		String returnString = fileName.substring(pos);
		if (logger.isDebugEnabled()) {
			logger.debug("getExtention(String) - end"); //$NON-NLS-1$
		}
		return returnString;
	}

	@Override
	public String execute() {
		if (logger.isDebugEnabled()) {
			logger.debug("execute() - start"); //$NON-NLS-1$
		}

		imageFileName = new Date().getTime() + getExtention(fileName);
		File imageFile = new File(ServletActionContext.getServletContext()
				.getRealPath("/UploadImages")
				+ "/"+ imageFileName);
		copy(myFile, imageFile);

		if (logger.isDebugEnabled()) {
			logger.debug("execute() - end"); //$NON-NLS-1$
		}
		return SUCCESS;
	}

}