@ScopeDesc(
    stateScope={ ${stateScope} },
    <#if attribDescsList?size gt 0>
        attribDescsList = {
            ${attribDescsList?join(",\n")}
        },
    </#if>
))}