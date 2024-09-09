<#list annotations as annotation>
    ${annotation}
</#list>
${accessModifier!"public"} ${returnType} ${name}(
    <#if parametersList?size gt 0> extends ${parametersList?join(", ")}</#if>
) {
    ${body}
}