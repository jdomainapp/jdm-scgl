package ${packageName};

<#list imports?sort as import>
import ${import};
</#list>

<#list annotations as annotation>
${annotation}
</#list>
public class ${className}<#if extendsList?size gt 0> extends ${extendsList?join(", ")}</#if> <#if implementsList?size gt 0> implements ${implementsList?join(", ")}</#if> {
    <#list attributes as attribute>
    ${attribute}
    </#list>

    <#list methods as method>
        ${method}
    </#list>
}