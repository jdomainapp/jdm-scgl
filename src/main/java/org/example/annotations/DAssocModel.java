package org.example.annotations;

import org.neo4j.driver.types.Node;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DAssocModel extends AnnotationModel {
    private static final List<String> defaultImports = List.of(new String[] {
        "jda.modules.dcsl.syntax.DAssoc",
        "jda.modules.dcsl.syntax.DAssoc.AssocEndType",
        "jda.modules.dcsl.syntax.DAssoc.AssocType",
        "jda.modules.dcsl.syntax.DAssoc.Associate",
    });

    private String ascName;
    private String role;
    private String ascType;
    private String endType;

    public static DAssocModel nodeToModel(Node node) {
        Map<String, Object> nodeProperties = node.asMap();

        DAssocModel model = new DAssocModel();
        model.ascName = nodeProperties.getOrDefault("ascName", "").toString();
        model.role = nodeProperties.getOrDefault("role", "").toString();
        model.ascType = nodeProperties.getOrDefault("ascType", "").toString();
        model.endType = nodeProperties.getOrDefault("endType", "").toString();

        model.imports = new HashSet<>(defaultImports);

        return model;
    }

    public String getAscName() {
        return ascName;
    }

    public String getRole() {
        return role;
    }

    public String getAscType() {
        return ascType;
    }

    public String getEndType() {
        return endType;
    }

    @Override
    public String getTemplateName() {
        return "templates/DAssoc.ftlh";
    }

}
