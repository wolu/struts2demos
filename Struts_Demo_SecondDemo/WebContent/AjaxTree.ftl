[
<#list wrappers as r>
    { "title": "${r.name}", "isFolder": <#if r.children?size gt 0>true<#else>false</#if>, "id": "${r.id}", "objectId": "${r.absolutePath?js_string}" }<#if r_has_next>,</#if>
</#list>
]