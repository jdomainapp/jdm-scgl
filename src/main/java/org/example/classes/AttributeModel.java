package org.example.classes;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.example.Freemarker;
import org.example.KnowledgeGraph;
import org.example.Utils;
import org.example.annotations.AnnotationModel;
import org.example.annotations.AttributeDescModel;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

public class AttributeModel {
    private String attributeDesc;
    private String accessModifier;
    private String dataType;
    private String name;
    private Set<String> imports;

    private ArrayList<String> annotations;

    public AttributeModel(Node node) {
        Map<String, Object> nodeProperties = node.asMap();

        accessModifier = nodeProperties.getOrDefault("accessModifier", "private").toString();
        dataType = nodeProperties.getOrDefault("dataType", "").toString();
        name = nodeProperties.getOrDefault("name", "").toString();
        imports = new HashSet<>();
        imports.addAll(List.of(Utils.splitIfNotEmpty(nodeProperties.getOrDefault("requiredImport", "").toString())));

        annotations = new ArrayList<>();

        try {
            /* dennis */
            List<Record> annotationNodes = KnowledgeGraph.query(String.format("MATCH (n:ATTRIBUTE)<-[:ATTACH_TO]-(a:ANNOTATION)-[:INSTANCE_OF]->(aType:ANNOTATION_TYPE) WHERE ID(n)=%s return a, aType.name", node.id()));
            for (Record r : annotationNodes) {
                Node annotationNode = r.get("a").asNode();
                String annotationType = r.get("aType.name").asString();
                AnnotationModel model = AnnotationModel.nodeToModel(annotationNode, annotationType);

                if (model != null) {
                    imports.addAll(model.getImports());
                    annotations.add(model.generate());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String bind() throws IOException {
        Template template = Freemarker.getTemplate("templates/Attribute.ftlh");

        try (StringWriter writer = new StringWriter()) {
            template.process(this, writer);
            return writer.toString();
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAttributeDesc() {
        return attributeDesc;
    }

    public String getAccessModifier() {
        return accessModifier;
    }

    public String getDataType() {
        return dataType;
    }

    public String getName() {
        return name;
    }

    public Set<String> getImports() {
        return imports;
    }

    public ArrayList<String> getAnnotations() {
        return annotations;
    }
}
