    @AttributeDesc(
        <#if label?? && label?has_content>label = "${label}",</#if> <#if alignX?? && alignX?has_content>alignX = ${alignX},</#if> <#if jsValidation??>jsValidation = ${jsValidation},</#if>
        <#if inputType?? && inputType?has_content>inputType = ${inputType},</#if>
        <#if type?? && type?has_content>type = ${type}.class,</#if>
        <#if ref?? && ref?has_content>ref = ${ref},</#if>
        <#if loadOidWithBoundValue>loadOidWithBoundValue = ${loadOidWithBoundValue?c},</#if>
        <#if displayOidWithBoundValue>displayOidWithBoundValue = ${displayOidWithBoundValue?c},</#if>
        <#if width gt 0>width = ${width},</#if>
        <#if height gt 0>height = ${height},</#if>
        <#if isStateEventSource>isStateEventSource = ${isStateEventSource?c},</#if>
        <#if id?? && id?has_content>id = "${id}",</#if>
        <#if editable?? && editable?has_content>editable = ${editable},</#if>
    )