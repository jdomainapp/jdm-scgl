package org.example.annotations;

import org.example.KnowledgeGraph;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.example.Constants.basePackage;

public class DClassModel extends AnnotationModel {
    private static final List<String> defaultImports = List.of(new String[] {
        "jda.modules.dcsl.syntax.DClass",
    });

    private String schema;

    public static DClassModel nodeToModel(Node node) {
        Map<String, Object> nodeProperties = node.asMap();

        DClassModel model = new DClassModel();
        model.schema = nodeProperties.getOrDefault("schema", "").toString();
        model.imports = new HashSet<>(defaultImports);

        return model;
    }

    public String getSchema() {
        return schema;
    }

    @Override
    public String getTemplateName() {
        return "templates/DClass.ftlh";
    }

}
