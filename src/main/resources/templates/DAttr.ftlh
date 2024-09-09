@DAttr(
    name = "${name}"
    <#if type??>, type = ${type}</#if>
    , optional = ${optional!"false"}
    , mutable = ${mutable!"true"}
    <#if id??>, id = ${id}</#if>
    <#if auto??>, auto = ${auto}</#if>
    <#if length??>, length = ${length}</#if>
    <#if serialisable??>, serialisable = ${serialisable}</#if>
)