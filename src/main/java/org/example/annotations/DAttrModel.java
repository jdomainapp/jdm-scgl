package org.example.annotations;

import org.neo4j.driver.types.Node;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DAttrModel extends AnnotationModel {
    private static final List<String> defaultImports = List.of(new String[] {
        "jda.modules.dcsl.syntax.DAttr",
        "jda.modules.dcsl.syntax.DAttr.Type",
    });

    private String name;
    private String type;
    private String mutable;
    private String optional;
    private String id;
    private String auto;
    private String length;
    private String serialisable;

    public static DAttrModel nodeToModel(Node node) {
        Map<String, Object> nodeProperties = node.asMap();

        DAttrModel model = new DAttrModel();
        model.name = nodeProperties.getOrDefault("name", "").toString();
        model.type = nodeProperties.getOrDefault("type", "").toString();
        model.mutable = nodeProperties.getOrDefault("mutable", "true").toString();
        model.optional = nodeProperties.getOrDefault("optional", "false").toString();
        model.id = nodeProperties.getOrDefault("id", "false").toString();
        model.auto = nodeProperties.getOrDefault("auto", "false").toString();
        model.length = nodeProperties.getOrDefault("length", "").toString();
        model.serialisable = nodeProperties.getOrDefault("serialisable", "true").toString();

        model.imports = new HashSet<>(defaultImports);

        return model;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getMutable() {
        return mutable;
    }

    public String getOptional() {
        return optional;
    }

    public String getAuto() {
        return auto;
    }

    public String getLength() {
        return length;
    }

    public String getSerialisable() {
        return serialisable;
    }

    @Override
    public String getTemplateName() {
        return "templates/DAttr.ftlh";
    }

}
