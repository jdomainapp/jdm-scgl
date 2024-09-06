@CTree(
    root=${root}.class,
    <#if stateScopeList?size gt 0>stateScope = { ${stateScopeList?join(", ")} }, </#if>
    <#if edgesList?size gt 0>
        edges = {
            ${edgesList?join(",\n")}
        },
    </#if>

    edges={
        // enrolmentmgmt -> student
        @CEdge(
            parent=EnrolmentMgmt.class, child=Student.class,
            scopeDesc = @ScopeDesc(
                stateScope = {"id", "name", "helpRequested", "modules"},

            // custom configuration for ModuleStudent
            attribDescs={
                // Student.name is not editable
                @AttributeDesc(
                    id="id",
                    type=JLabelField.class),
                @AttributeDesc(
                    id="name",
                    type=JLabelField.class,
                    editable=false
                ),
        }
    ))}
)