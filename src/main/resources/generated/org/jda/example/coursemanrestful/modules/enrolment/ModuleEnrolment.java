package org.jda.example.coursemanrestful.modules.enrolment;

import java.util.Date;
import jda.modules.common.types.Null;
import jda.modules.dcsl.syntax.Select;
import jda.modules.mccl.conceptmodel.module.ModuleType;
import jda.modules.mccl.conceptmodel.view.RegionName;
import jda.modules.mccl.conceptmodel.view.RegionType;
import jda.modules.mccl.syntax.containment.CTree;
import jda.modules.mccl.syntax.controller.ControllerDesc;
import jda.modules.mccl.syntax.controller.ControllerDesc.*;
import jda.modules.mccl.syntax.InputTypes;
import jda.modules.mccl.syntax.JSValidation;
import jda.modules.mccl.syntax.MCCLConstants.AlignmentX;
import jda.modules.mccl.syntax.model.ModelDesc;
import jda.modules.mccl.syntax.ModuleDescriptor;
import jda.modules.mccl.syntax.SetUpDesc;
import jda.modules.mccl.syntax.view.AttributeDesc;
import jda.modules.mccl.syntax.view.ViewDesc;
import jda.modules.setup.commands.*;
import jda.mosa.controller.*;
import jda.mosa.view.assets.datafields.list.JComboField;
import jda.mosa.view.assets.panels.DefaultPanel;
import jda.mosa.view.View;
import org.jda.example.coursemanrestful.modules.coursemodule.model.CourseModule;
import org.jda.example.coursemanrestful.modules.enrolment.model.Enrolment;
import org.jda.example.coursemanrestful.modules.student.model.Student;

@ModuleDescriptor(
    name = "ModuleEnrolment",
    modelDesc = @ModelDesc(
        model = Enrolment.class
    ),
    viewDesc = @ViewDesc(
        formTitle = "Manage Enrolment",
        domainClassLabel = "Enrolment",
        imageIcon = "enrolment.jpg",
        view = View.class,
        viewType = RegionType.Data,
        parent = RegionName.Tools,
        topX = -1,
        topY = -1,
        widthRatio = -1f,
        heightRatio = -1f,
        children = {
            
        },
        excludeComponents = {
            
        },
        props = {
            
        }
    ),
    controllerDesc = @ControllerDesc(
        controller = Controller.class,
        openPolicy = OpenPolicy.I,
        isDataFieldStateListener = true
    ),
    setUpDesc = @SetUpDesc(
        postSetUp = CopyResourceFilesCommand.class
    ),
    subtypes = {
        
    },
    type = ModuleType.DomainData,
    isPrimary = true,
    modelDesc = @ModelDesc(
        model = Enrolment.class
    )
    , containmentTree = @CTree(
        root=Enrolment.class,
        stateScope = {  }, 
        edges = {
            @CEdge(
                parent=Enrolment.class,
                child=Student.class,
                scopeDesc = @ScopeDesc(
    stateScope={ "id", "name", "helpRequested", "modules" },
        attribDescsList = {
                @AttributeDesc(
          
        
        type = JLabelField.class,
        
        
        
        
        
        
        id = "name",
        
    ),
    @AttributeDesc(
          
        
        type = JLabelField.class,
        
        
        
        
        
        
        id = "id",
        
    )
        },
))}
            )
        },
    )
)
public class ModuleEnrolment  {
        
            @AttributeDesc(
        label = "Id", alignX = AlignmentX.Center, 
        
        
        
        
        
        
        
        
        
        
    )
    private int id;
        
            @AttributeDesc(
        label = "Course Module", alignX = AlignmentX.Center, 
        
        type = JComboField.class,
        ref = @Select(
        clazz = CourseModule.class,
        attributes = {
            "code"
        }
    ),
        
        
        width = 80,
        height = 25,
        isStateEventSource = true,
        
        
    )
    private CourseModule courseModule;
        
            @AttributeDesc(
        label = "Manage Enrolments",  
        
        
        
        
        
        
        
        
        
        
    )
    private String title;
        
            @AttributeDesc(
        label = "Date range",  
        inputType = InputTypes.DateRangeStart,
        
        
        
        
        
        
        
        id = "date_range",
        
    )
    private Date startDate;
        
            @AttributeDesc(
        label = "Student",  
        
        type = JComboField.class,
        ref = @Select(
        clazz = Student.class,
        attributes = {
            "name"
        }
    ),
        loadOidWithBoundValue = true,
        displayOidWithBoundValue = true,
        
        
        
        
        
    )
    private Student student;
        
            @AttributeDesc(
        label = "Date range",  
        inputType = InputTypes.DateRangeEnd,
        
        
        
        
        
        
        
        id = "date_range",
        
    )
    private Date endDate;
        
            @AttributeDesc(
        label = "Exam Mark", alignX = AlignmentX.Center, 
        
        
        
        
        
        
        
        
        
        
    )
    private double examMark;
        
            @AttributeDesc(
        label = "Final Grade", alignX = AlignmentX.Center, 
        
        
        
        
        
        
        
        
        
        
    )
    private char finalGrade;
        
            @AttributeDesc(
        label = "Internal Mark", alignX = AlignmentX.Center, 
        
        
        
        
        
        
        
        
        
        
    )
    private double internalMark;

}