    <#list annotations as annotation>
        ${annotation}
    </#list>
    ${accessModifier!"private"} ${dataType} ${name};