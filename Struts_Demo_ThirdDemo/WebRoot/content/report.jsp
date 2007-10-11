<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page import="java.io.File"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>

<%@ page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@ page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@ page import="net.sf.jasperreports.j2ee.servlets.*"%>

<%@ page import="net.sf.jasperreports.engine.JRException"%>
<%@ page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@ page import="net.sf.jasperreports.engine.export.JRHtmlExporter"%>
<%@ page
	import="net.sf.jasperreports.engine.export.JRHtmlExporterParameter"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:i18n name="ThirdDemoMessages">
	<s:text name="ReportPage.title" />
</s:i18n></title>
</head>
<body>
<s:i18n name="ThirdDemoMessages">
	<s:text name="ReportPage.info" />
</s:i18n>
<br>

<s:a href="../generatePDFReport.action">
	<s:i18n name="ThirdDemoMessages">
		<s:text name="ReportPage.report.pdf" />
	</s:i18n>
</s:a>
&nbsp;
<s:a href="../generateXLSReport.action">
	<s:i18n name="ThirdDemoMessages">
		<s:text name="ReportPage.report.xls" />
	</s:i18n>
</s:a>
<br>
<s:i18n name="ThirdDemoMessages">
	<s:text name="ReportPage.report.html" />
</s:i18n>
<%
	String dbDriver = "com.mysql.jdbc.Driver";
	String dbURL = "jdbc:mysql://localhost/quickstart?user=root&password=gamiao&useUnicode=true&characterEncoding=gb2312";
	Class.forName(dbDriver);

	String rowid = "1";//初始化变量
	Connection conn = DriverManager.getConnection(dbURL);//从数据源连接数据库
	//装载jasper文件application
	File exe_rpt = new File(application
			.getRealPath("reports/ThirdDemoReport.jasper"));
	//rowid就是iReport的变量$P{rowid}的名称
	Map<String, String> parameters = new HashMap<String, String>();
	parameters.put("rowid", rowid);
	try {
		// fill
		JasperPrint jasperPrint = JasperFillManager.fillReport(exe_rpt
				.getPath(), parameters, conn);

		// 生成html
		JRHtmlExporter htmlExporter = new JRHtmlExporter();
		session.setAttribute(
				ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,
				jasperPrint);
		htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT,
				jasperPrint);
		htmlExporter.setParameter(JRExporterParameter.OUTPUT_WRITER,
				out);
		//exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "../servlets/image?image=");       	
		htmlExporter.setParameter(
				JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
				Boolean.FALSE);
		htmlExporter.exportReport();

	} catch (JRException ex) {
		System.out.println("Jasper Output Error:" + ex.getMessage());
	} finally {
		conn.close();
	}
%>
</body>
</html>