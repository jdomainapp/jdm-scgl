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

public class ScopeDescModel extends AnnotationModel {
    private static final List<String> defaultImports = List.of(new String[] {
        "jda.modules.mccl.syntax.containment.CEdge",
        "jda.modules.mccl.syntax.containment.ScopeDesc"
    });

    private String stateScope;
    private ArrayList<String> attribDescsList;


    public static ScopeDescModel nodeToModel(Node node) {
        Map<String, Object> nodeProperties = node.asMap();

        ScopeDescModel model = new ScopeDescModel();
        model.imports = new HashSet<>(defaultImports);

        model.stateScope = nodeProperties.getOrDefault("stateScope", "").toString();

        model.attribDescsList = new ArrayList<>();

        try {
            String query = String.format("MATCH (n:ANNOTATION)-[:HAS_ATTRIBUTE]->(attributeDesc:ANNOTATION) WHERE ID(n)=%s RETURN attributeDesc", node.id());
            List<Record> records = KnowledgeGraph.query(query);
            for (Record r : records) {
                Node annotationNode = r.get("attributeDesc").asNode();
                AttributeDescModel attributeDescModel = AttributeDescModel.nodeToModel(annotationNode);

                if (attributeDescModel != null) {
                    model.imports.addAll(attributeDescModel.getImports());
                    model.attribDescsList.add(attributeDescModel.generate());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return model;
    }

    @Override
    public String getTemplateName() {
        return "templates/ScopeDesc.ftlh";
    }

    public String getStateScope() {
        return stateScope;
    }

    public ArrayList<String> getAttribDescsList() {
        return attribDescsList;
    }
}
