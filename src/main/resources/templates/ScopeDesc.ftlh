@CEdge(
    parent=EnrolmentMgmt.class,
    child=Student.class,
    scopeDesc = @ScopeDesc(
        stateScope = {"id", "name", "helpRequested", "modules"},

        attribDescs={
            // Student.name is not editable
            @AttributeDesc(
                id="id",
                type=JLabelField.class
            ),
            @AttributeDesc(
                id="name",
                type=JLabelField.class,
                editable=false
            ),
}