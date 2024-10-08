package org.example.annotations;

import org.example.KnowledgeGraph;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.example.Constants.basePackage;

public class ModelDescModel extends AnnotationModel {
    private static final List<String> defaultImports = List.of(new String[] {
        "jda.modules.mccl.syntax.model.ModelDesc",
    });

    private String domainClass;

    public static ModelDescModel nodeToModel(Node node) {
        Map<String, Object> nodeProperties = node.asMap();

        ModelDescModel modelDescModel = new ModelDescModel();
        modelDescModel.imports = new HashSet<>(defaultImports);

        try {
            List<Record> records = KnowledgeGraph.query(String.format("MATCH (:ANNOTATION {name: \"%s\"})-[:HAS_DOMAIN_CLASS]->(domainClass:CLASS) RETURN domainClass", nodeProperties.get("name")));
            if (!records.isEmpty()) {
                Node domainClassNode = records.get(0).get("domainClass").asNode();
                String domainClassName = domainClassNode.get("name").asString();
                String domainClassPackage = domainClassNode.get("packageName").asString();

                modelDescModel.domainClass = domainClassName;
                modelDescModel.imports.add(basePackage + "." + domainClassPackage + "." + domainClassName);
            } else {
                modelDescModel.domainClass = "Null";
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return modelDescModel;
    }

    @Override
    public String getTemplateName() {
        return "templates/ModelDesc.ftlh";
    }

    public String getDomainClass() {
        return domainClass;
    }
}
