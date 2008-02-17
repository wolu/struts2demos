package com.gamiao.struts2.demo.thirddemo.action;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 * 
 */
public class ReportAction extends ActionSupport {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ReportAction.class);

	public String generatePDFReport() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("generatePDFReport() - start"); //$NON-NLS-1$
		}

		// get the request,response & session
		HttpServletResponse response = ServletActionContext.getResponse();
		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");

		// initial db connection for report
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost/quickstart?user=root&password=gamiao&useUnicode=true&characterEncoding=gb2312";
		Class.forName(dbDriver);
		Connection conn = DriverManager.getConnection(dbURL);

		// get current time
		Date now = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");

		// load jasper file
		String reportFilePath = "reports\\ThirdDemoReport.jasper";
		if (logger.isDebugEnabled()) {
			logger
					.debug("generatePDFReport() - The jasper file path:" + basePath + reportFilePath); //$NON-NLS-1$
		}
		File jasperFile = new File(basePath + reportFilePath);

		// initial parameters for jasper report
		Map<String, String> parameters = new HashMap<String, String>();
		String rowid = "1";
		parameters.put("rowid", rowid);

		try {
			// generate pdf report
			byte[] pdfBytes = JasperRunManager.runReportToPdf(jasperFile
					.getPath(), parameters, conn);

			// generate response properties
			response.setContentType("application/pdf");
			response.setContentLength(pdfBytes.length);
			response.setHeader("Content-Disposition", "attachment;filename=\""
					+ "ThirdDemoReport" + timeFormat.format(now) + ".pdf"
					+ "\"");

			// output file stream
			ServletOutputStream pdfOuputStream = response.getOutputStream();
			pdfOuputStream.write(pdfBytes, 0, pdfBytes.length);
			pdfOuputStream.flush();
			pdfOuputStream.close();

		} catch (JRException ex) {
			logger.error("generatePDFReport()", ex); //$NON-NLS-1$

			if (logger.isDebugEnabled()) {
				logger
						.debug("generatePDFReport() - Jasper Output Error:" + ex.getMessage()); //$NON-NLS-1$
			}
		} finally {
			conn.close();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("generatePDFReport() - end"); //$NON-NLS-1$
		}
		return null;
	}

	public String generateXLSReport() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("generateXLSReport() - start"); //$NON-NLS-1$
		}

		// get the request,response & session
		HttpServletResponse response = ServletActionContext.getResponse();
		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");

		// initial db connection for report
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost/quickstart?user=root&password=gamiao&useUnicode=true&characterEncoding=gb2312";
		Class.forName(dbDriver);
		Connection conn = DriverManager.getConnection(dbURL);

		// get current time
		Date now = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");

		// load jasper file
		String reportFilePath = "reports\\ThirdDemoReport.jasper";
		if (logger.isDebugEnabled()) {
			logger
					.debug("generateXLSReport() - The jasper file path:" + basePath + reportFilePath); //$NON-NLS-1$
		}
		File jasperFile = new File(basePath + reportFilePath);

		// initial parameters for jasper report
		Map<String, String> parameters = new HashMap<String, String>();
		String rowid = "1";
		parameters.put("rowid", rowid);

		try {
			// fill jasper report
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile
					.getPath(), parameters, conn);

			// generate excel report
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			JRXlsExporter xlsExporter = new JRXlsExporter();
			xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT,
					jasperPrint);
			xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
					outStream);

			// erase the empty space
			xlsExporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			// erase the ColumnHeader
			xlsExporter
					.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
							Boolean.FALSE);
			// show frame
			xlsExporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);
			xlsExporter.exportReport();

			byte[] xlsBytes = outStream.toByteArray();
			if (xlsBytes != null && xlsBytes.length > 0) {

				// generate response properties
				response.reset();
				response.setContentType("application/vnd.ms-excel");
				response.setContentLength(xlsBytes.length);
				response.setHeader("Content-Disposition",
						"attachment;filename=\"" + "ThirdDemoReport"
								+ timeFormat.format(now) + ".xls" + "\"");

				// output file stream
				ServletOutputStream xlsOuputStream = response.getOutputStream();
				xlsOuputStream.write(xlsBytes, 0, xlsBytes.length);
				xlsOuputStream.flush();
				xlsOuputStream.close();
			}
		} catch (JRException ex) {
			logger.error("generateXLSReport()", ex); //$NON-NLS-1$

			if (logger.isDebugEnabled()) {
				logger
						.debug("generateXLSReport() - Jasper Output Error:" + ex.getMessage()); //$NON-NLS-1$
			}
		} finally {
			conn.close();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("generateXLSReport() - end"); //$NON-NLS-1$
		}
		return null;
	}
}
