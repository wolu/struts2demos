<script type="text/javascript">
/* <![CDATA[ */
    dojo.require("dojo.lang.*");
    dojo.require("dojo.widget.*");
    dojo.require("dojo.widget.Tree");
    dojo.require("dojo.widget.TreeRPCController");    <#-- Added by Max -->            
/* ]]> */
</script>    
<#-- Added by Max -->             
<div dojoType="TreeRPCController" 
     widgetId="${parameters.id?html}_controller"
     DNDcontroller="create" 
     RPCUrl="<@s.url />">
</div>
<#-- End -->    
<div dojoType="Tree"   
    <#if parameters.blankIconSrc?exists>
    gridIconSrcT="<@s.url value='${parameters.blankIconSrc}' encode="false" includeParams='none'/>"
    </#if>
    <#if parameters.gridIconSrcL?exists>
    gridIconSrcL="<@s.url value='${parameters.gridIconSrcL}' encode="false" includeParams='none'/>"
    </#if>
    <#if parameters.gridIconSrcV?exists>
    gridIconSrcV="<@s.url value='${parameters.gridIconSrcV}' encode="false" includeParams='none'/>"
    </#if>
    <#if parameters.gridIconSrcP?exists>
    gridIconSrcP="<@s.url value='${parameters.gridIconSrcP}' encode="false" includeParams='none'/>"
    </#if>
    <#if parameters.gridIconSrcC?exists>
    gridIconSrcC="<@s.url value='${parameters.gridIconSrcC}' encode="false" includeParams='none'/>"
    </#if>
    <#if parameters.gridIconSrcX?exists>
    gridIconSrcX="<@s.url value='${parameters.gridIconSrcX}' encode="false" includeParams='none'/>"
    </#if>
    <#if parameters.gridIconSrcY?exists>
    gridIconSrcY="<@s.url value='${parameters.gridIconSrcY}' encode="false" includeParams='none'/>"
    </#if>
    <#if parameters.gridIconSrcZ?exists>
    gridIconSrcZ="<@s.url value='${parameters.gridIconSrcZ}' encode="false" includeParams='none'/>"
    </#if>
    <#if parameters.expandIconSrcPlus?exists>
    expandIconSrcPlus="<@s.url value='${parameters.expandIconSrcPlus}' includeParams='none'/>"
    </#if>
    <#if parameters.expandIconSrcMinus?exists>
    expandIconSrcMinus="<@s.url value='${parameters.expandIconSrcMinus?html}' includeParams='none'/>"
    </#if>
    <#if parameters.iconWidth?exists>
    iconWidth="<@s.url value='${parameters.iconWidth?html}' encode="false" includeParams='none'/>"
    </#if>
    <#if parameters.iconHeight?exists>
    iconHeight="<@s.url value='${parameters.iconHeight?html}' encode="false" includeParams='none'/>"
    </#if>
    <#if parameters.toggleDuration?exists>
    toggleDuration=${parameters.toggleDuration?c}
    </#if>
    <#if parameters.templateCssPath?exists>
    templateCssPath="<@s.url value='${parameters.templateCssPath}' encode="false" includeParams='none'/>"
    </#if>
    <#if parameters.showGrid?exists>
    showGrid="${parameters.showGrid?default(true)?string}"
    </#if>
    <#if parameters.showRootGrid?exists>
    showRootGrid="${parameters.showRootGrid?default(true)?string}"
    </#if>
    <#if parameters.id?exists>
    id="${parameters.id?html}"
    </#if>
    <#if parameters.treeSelectedTopic?exists>
    publishSelectionTopic="${parameters.treeSelectedTopic?html}"
    </#if>
    <#if parameters.treeExpandedTopic?exists>
    publishExpandedTopic="${parameters.treeExpandedTopic?html}"
    </#if>
    <#if parameters.treeCollapsedTopic?exists>
    publishCollapsedTopic="${parameters.treeCollapsedTopic?html}"
    </#if>
    <#if parameters.toggle?exists>
    toggle="${parameters.toggle?html}"
    </#if>
    controller="${parameters.id?html}_controller" <#-- Added by Max -->    
    >
    <#if parameters.label?exists>
    <div dojoType="TreeNode" title="${parameters.label?html}"
    <#if parameters.nodeIdProperty?exists>
    id="${stack.findValue(parameters.nodeIdProperty)}"
    <#else>
    id="${parameters.id}_root"
    </#if>
    >
    <#elseif parameters.rootNode?exists>
    ${stack.push(parameters.rootNode)}
    <#-- Edited by Max -->    
    <div dojoType="TreeNode" 
             title="${stack.findValue(parameters.nodeTitleProperty)}"
             widgetId="${stack.findValue(parameters.nodeIdProperty)}"
             isFolder="<#if stack.findValue(parameters.childCollectionProperty)?size gt 0>true<#else>false</#if>"
             objectId="${stack.findValue(parameters.nameValue)}">
        </div>
    <#-- End -->        
    <#assign oldNode = stack.pop()/> <#-- pop the node off of the stack, but don't show it -->
    </#if> 