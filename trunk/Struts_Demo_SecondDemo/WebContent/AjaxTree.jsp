<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Struts 2 AJAX - More Tree</title>
        <s:head theme="ajax" debug="true" />
        <script type="text/javascript">
        /* <![CDATA[ */
            function treeNodeSelected(arg) {
                alert(arg.source.title + ' selected');
            }
                
            dojo.addOnLoad(function() {                
                var t = dojo.widget.byId('appFiles');                
                var s = t.selector;                
                dojo.event.connect(s, 'select', 'treeNodeSelected');
            });    
        /* ]]> */    
        </script>
    </head>
    <body>
        <h2>
            AJAX Tree Example
        </h2>
        <div style="float:left; margin-right: 50px;">
            <script type="text/javascript">
            /* <![CDATA[ */
                dojo.require("dojo.lang.*");
                dojo.require("dojo.widget.*");
                dojo.require("dojo.widget.Tree");
                dojo.require("dojo.widget.TreeRPCController");                
             /* ]]> */
             </script>             
            <div dojoType="TreeRPCController" widgetId="treeController"
                DNDcontroller="create" RPCUrl="<s:url />"></div>
            <div dojoType="Tree" widgetId="appFiles" toggle="fade" controller="treeController">
                <div dojoType="TreeNode" title='<s:property value="root.name" />'
                    widgetId='<s:property value="root.id" />'
                    isFolder='<s:property value="root.children.length > 0" />'
                    objectId='<s:property value="root.absolutePath" />'>
                </div>
            </div>
        </div>
    </body>
</html>