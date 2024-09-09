package org.example.annotations;

import org.neo4j.driver.types.Node;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MethodModel extends AnnotationModel {
    private static final List<String> defaultImports = List.of(new String[] {
    });

    private String name;


    public static MethodModel nodeToModel(Node node) {
        Map<String, Object> nodeProperties = node.asMap();

        MethodModel model = new MethodModel();
        model.name = nodeProperties.getOrDefault("name", "").toString();

        model.imports = new HashSet<>(defaultImports);

        return model;
    }

    @Override
    public String getTemplateName() {
        return "templates/Method.ftlh";
    }

}
