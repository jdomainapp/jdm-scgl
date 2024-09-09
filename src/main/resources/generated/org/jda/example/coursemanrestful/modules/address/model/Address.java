package org.jda.example.coursemanrestful.modules.address.model;

import jda.modules.dcsl.syntax.DAssoc;
import jda.modules.dcsl.syntax.DAssoc.AssocEndType;
import jda.modules.dcsl.syntax.DAssoc.Associate;
import jda.modules.dcsl.syntax.DAssoc.AssocType;
import jda.modules.dcsl.syntax.DAttr;
import jda.modules.dcsl.syntax.DAttr.Type;
import jda.modules.dcsl.syntax.DClass;
import org.jda.example.coursemanrestful.jda.modules.patterndom.assets.domevents.Publisher;
import org.jda.example.coursemanrestful.jda.modules.patterndom.assets.domevents.Subcriber;
import org.jda.example.coursemanrestful.modules.student.model.Student;

@DClass(schema="courseman")
public class Address  implements Subcriber, Publisher {
        
        @DAssoc(
    ascName = "student-has-city",
    role = "city",
    ascType = AssocType.One2One,
    endType = AssocEndType.One,
    associate = @Associate(
        type = Student.class,
        cardMin = 1,
        cardMax = 1,
        determinant = true
    )
)

        @DAttr(
    name = "student"
    , type = Type.Domain
    , optional = false
    , mutable = true
    , id = false
    , auto = false
    , length = 
    , serialisable = true
)
    private Student student;
        
        @DAttr(
    name = "name"
    , type = Type.String
    , optional = false
    , mutable = true
    , id = false
    , auto = false
    , length = 
    , serialisable = true
)
    private String name;
        
        @DAttr(
    name = "id"
    , type = Type.Integer
    , optional = false
    , mutable = false
    , id = true
    , auto = true
    , length = 3
    , serialisable = true
)
    private int id;

}