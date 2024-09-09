@CTree(
        root=${root}.class,
        <#if stateScope??>stateScope = { ${stateScope} }, </#if>
        <#if edgesList?size gt 0>
        edges = {
            ${edgesList?join(",\n")}
        },
        </#if>
    )