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

public class CTreeModel extends AnnotationModel {
    private static final List<String> defaultImports = List.of(new String[] {
        "jda.modules.mccl.syntax.containment.CTree",
    });

    private String root;
    private String stateScope;

    private ArrayList<String> edgesList;

    public static CTreeModel nodeToModel(Node node) {
        Map<String, Object> nodeProperties = node.asMap();

        CTreeModel model = new CTreeModel();
        model.imports = new HashSet<>(defaultImports);

        // root
        try {
            List<Record> records = KnowledgeGraph.query(String.format("MATCH (n:ANNOTATION)-[:HAS_ROOT]->(root:CLASS) WHERE ID(n)=%s RETURN root", node.id()));
            if (!records.isEmpty()) {
                Node domainClass = records.get(0).get("root").asNode();
                String domainClassName = domainClass.get("name").asString();
                String domainClassPackage = domainClass.get("packageName").asString();

                model.root = domainClassName;
                model.imports.add(basePackage + "." + domainClassPackage + "." + domainClassName);
            } else {
                model.root = "Null";
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        model.stateScope = nodeProperties.getOrDefault("stateScope", "").toString();

        // edgelist
        ArrayList<String> edgesList = new ArrayList<>();

        try {
            List<Record> records = KnowledgeGraph.query(String.format("MATCH (n:ANNOTATION)-[:HAS_ROOT]->(root:CLASS) WHERE ID(n)=%s RETURN root", node.id()));
            if (!records.isEmpty()) {
                Node domainClass = records.get(0).get("root").asNode();
                String domainClassName = domainClass.get("name").asString();
                String domainClassPackage = domainClass.get("packageName").asString();

                model.root = domainClassName;
                model.imports.add(basePackage + "." + domainClassPackage + "." + domainClassName);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        model.edgesList = edgesList;

        return model;
    }

    @Override
    public String getTemplateName() {
        return "templates/CTree.ftlh";
    }

    public String getRoot() {
        return root;
    }

    public String getStateScope() {
        return stateScope;
    }

    public ArrayList<String> getEdgesList() {
        return edgesList;
    }
}
