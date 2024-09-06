package org.example.annotations;

import org.example.KnowledgeGraph;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.example.Constants.basePackage;

public class CEdgeModel extends AnnotationModel {
    private static final List<String> defaultImports = List.of(new String[] {
        "jda.modules.mccl.syntax.containment.CEdge",
        "jda.modules.mccl.syntax.containment.ScopeDesc"
    });

    private String parent;
    private String child;
    private String scopeDesc;

    public static CEdgeModel nodeToModel(Node node) {
        Map<String, Object> nodeProperties = node.asMap();

        CEdgeModel model = new CEdgeModel();
        model.imports = new HashSet<>(defaultImports);

        // parent
        try {
            List<Record> records = KnowledgeGraph.query(String.format("MATCH (root:CLASS)<-[:HAS_ROOT]-(:ANNOTATION)-[:HAS_CONTAINMENT_EDGE]->(n:ANNOTATION) WHERE ID(n)=%s RETURN root", node.id()));
            if (!records.isEmpty()) {
                Node domainClass = records.get(0).get("root").asNode();
                String domainClassName = domainClass.get("name").asString();
                String domainClassPackage = domainClass.get("packageName").asString();

                model.parent = domainClassName;
                model.imports.add(basePackage + "." + domainClassPackage + "." + domainClassName);
            } else {
                model.parent = "Null";
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // child
        try {
            List<Record> records = KnowledgeGraph.query(String.format("MATCH (n:ANNOTATION)-[:HAS_CHILD]->(child:CLASS) WHERE ID(n)=%s RETURN child", node.id()));
            if (!records.isEmpty()) {
                Node domainClass = records.get(0).get("child").asNode();
                String domainClassName = domainClass.get("name").asString();
                String domainClassPackage = domainClass.get("packageName").asString();

                model.child = domainClassName;
                model.imports.add(basePackage + "." + domainClassPackage + "." + domainClassName);
            } else {
                model.child = "Null";
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // scope desc
        try {
            List<Record> records = KnowledgeGraph.query(String.format("MATCH (n:ANNOTATION)-[:HAS_SCOPE]->(scope:ANNOTATION) WHERE ID(n)=%s RETURN scope", node.id()));
            if (!records.isEmpty()) {
                Node domainClass = records.get(0).get("scope").asNode();
                String domainClassName = domainClass.get("name").asString();

                model.child = domainClassName;
                model.imports.add(basePackage + "." + domainClassPackage + "." + domainClassName);
            } else {
                model.child = "Null";
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return model;
    }

    @Override
    public String getTemplateName() {
        return "templates/CEdge.ftlh";
    }

    public String getParent() {
        return parent;
    }

    public String getChild() {
        return child;
    }
}
