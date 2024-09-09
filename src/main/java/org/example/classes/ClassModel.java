package org.example.classes;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.example.Freemarker;
import org.example.KnowledgeGraph;
import org.example.annotations.AnnotationModel;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

import static org.example.Constants.basePackage;

public class ClassModel {
    private String className;
    private String packageName;
    private String sourceFilePath;
    private Set<String> imports;
    private ArrayList<String> extendsList;
    private ArrayList<String> annotations;
    private ArrayList<String> attributes;
    private ArrayList<String> methods;
    private ArrayList<String> implementsList;

    public String getClassName() {
        return className;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public Set<String> getImports() {
        return imports;
    }

    public ArrayList<String> getExtendsList() {
        return extendsList;
    }
    public ArrayList<String> getImplementsList() {
        return implementsList;
    }

    public ArrayList<String> getAnnotations() {
        return annotations;
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    public ArrayList<String> getMethods() {
        return methods;
    }

    public static ClassModel nodeToModel(Node node) {
        Map<String, Object> nodeProperties = node.asMap();

        ClassModel classModel = new ClassModel();
        classModel.className = nodeProperties.getOrDefault("name", "").toString();
        classModel.packageName = basePackage + "." + nodeProperties.getOrDefault("packageName", "").toString();
        classModel.sourceFilePath = nodeProperties.getOrDefault("sourceFilePath", "").toString();
        classModel.imports = new HashSet<>();

        ArrayList<String> extendsList = new ArrayList<>();
        ArrayList<String> implementsList = new ArrayList<>();
        ArrayList<String> annotations = new ArrayList<>();
        ArrayList<String> attributes = new ArrayList<>();
        ArrayList<String> methods = new ArrayList<>();

        try {
            // extends
            List<Record> extendNodes = KnowledgeGraph.query(String.format("MATCH (:CLASS {name: \"%s\"})-[:EXTENDS]->(n:CLASS) RETURN n", classModel.getClassName()));
            extendNodes.forEach(r -> {
                Node extendNode = r.get("n").asNode();
                String name = extendNode.get("name").asString();
                String packageName = extendNode.get("packageName").asString();

                extendsList.add(name);
                classModel.imports.add(basePackage + "." + packageName + "." + name);
            });

            // implements
            List<Record> implementsNodes = KnowledgeGraph.query(String.format("MATCH (:CLASS {name: \"%s\"})-[:IMPLEMENTS]->(n:INTERFACE) RETURN n", classModel.getClassName()));
            implementsNodes.forEach(r -> {
                Node implementNode = r.get("n").asNode();
                String name = implementNode.get("name").asString();
                String packageName = implementNode.get("packageName").asString();

                implementsList.add(name);
                classModel.imports.add(basePackage + "." + packageName + "." + name);
            });

            // annotations
            List<Record> annotationNodes = KnowledgeGraph.query(String.format("MATCH (:CLASS {name: \"%s\"})<-[:ATTACH_TO]-(a:ANNOTATION)-[:INSTANCE_OF]->(aType:ANNOTATION_TYPE) return a, aType.name", classModel.getClassName()));
            for (Record r : annotationNodes) {
                Node annotationNode = r.get("a").asNode();
                String annotationType = r.get("aType.name").asString();
                AnnotationModel model = AnnotationModel.nodeToModel(annotationNode, annotationType);

                if (model != null) {
                    classModel.imports.addAll(model.getImports());
                    annotations.add(model.generate());
                }
            }

            // attributes
            List<Record> attributeNodes = KnowledgeGraph.query(String.format("MATCH (n:CLASS)-[:HAS_ATTRIBUTE]->(attribute:ATTRIBUTE) WHERE ID(n)=%s RETURN attribute", node.id()));
            for (Record r : attributeNodes) {
                Node attributeNode = r.get("attribute").asNode();
                AttributeModel model = new AttributeModel(attributeNode);
                classModel.imports.addAll(model.getImports());
                attributes.add(model.bind());
            }

            // methods

        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }

        classModel.extendsList = extendsList;
        classModel.implementsList = implementsList;
        classModel.annotations = annotations;
        classModel.attributes = attributes;
        classModel.methods = methods;

        return classModel;
    }

    public void generate(String originalJdaDirectory, String projectDirectory) throws IOException {
        File outDir = new File(projectDirectory + File.separator + packageName.replace(".", File.separator));
        outDir.mkdirs();

        File outFile = new File(projectDirectory + File.separator + packageName.replace(".", File.separator) + File.separator + className + ".java");

        if (sourceFilePath.isEmpty()) {
            Template template = Freemarker.getTemplate("templates/Class.ftlh");

            try (var fileWriter = new FileWriter(outFile)) {
                template.process(this, fileWriter);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } else {
            try {
                File sourceFile = new File(originalJdaDirectory + File.separator + sourceFilePath);
                Files.copy(sourceFile.toPath(), outFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
