package org.jda.example.coursemanrestful.modules.coursemodule;

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
import org.jda.example.coursemanrestful.modules.coursemodule.ModuleCompulsoryModule;
import org.jda.example.coursemanrestful.modules.coursemodule.ModuleElectiveModule;

@ModuleDescriptor(
    name = "ModuleCourseModule",
    modelDesc = @ModelDesc(
        model = CourseModule.class
    ),
    viewDesc = @ViewDesc(
        formTitle = "Manage Course Modules",
        domainClassLabel = "Course Module",
        imageIcon = "coursemodule.jpg",
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
        isDataFieldStateListener = false
    ),
    setUpDesc = @SetUpDesc(
        postSetUp = CopyResourceFilesCommand.class
    ),
    subtypes = {
        ModuleCompulsoryModule.class,
		ModuleElectiveModule.class
    },
    type = ModuleType.DomainData,
    isPrimary = true,
    modelDesc = @ModelDesc(
        model = CourseModule.class
    )
    
)
public class ModuleCourseModule  {
        
            @AttributeDesc(
        label = "Form: Course Module",  
        
        
        
        
        
        
        
        
        
        
    )
    private String title;
        
            @AttributeDesc(
        label = "Rating",  
        inputType = InputTypes.Rating,
        
        
        
        
        
        
        
        
        
    )
    private int rating;
        
            @AttributeDesc(
        label = "Id", alignX = AlignmentX.Center, 
        
        
        
        
        
        
        
        
        
        
    )
    private int id;
        
            @AttributeDesc(
        label = "Credits", alignX = AlignmentX.Center, jsValidation = @JSValidation(
        optional = false,
        regex = "/^\\d+$/",
        invalidMsg = "Credits must be a number or a float number!"
    ),
        
        
        
        
        
        
        
        
        
        
    )
    private int credits;
        
            @AttributeDesc(
        label = "Cost",  
        inputType = InputTypes.Slider,
        
        
        
        
        
        
        
        
        
    )
    private int cost;
        
            @AttributeDesc(
        label = "Semester", alignX = AlignmentX.Center, 
        
        
        
        
        
        
        
        
        
        
    )
    private int semester;
        
            @AttributeDesc(
        label = "Code", alignX = AlignmentX.Center, 
        
        
        
        
        
        
        
        
        
        
    )
    private String code;
        
            @AttributeDesc(
        label = "Description",  jsValidation = @JSValidation(
        optional = true,
        regex = "/^[A-Za-z\\s]$/",
        invalidMsg = "Description must only include characters!"
    ),
        inputType = InputTypes.TextArea,
        
        
        
        
        
        
        
        
        
    )
    private String description;
        
            @AttributeDesc(
        label = "Name",  jsValidation = @JSValidation(
        optional = false,
        regex = "/^S\\d+$/",
        invalidMsg = "Name must start with 'S' and followed by one or more numbers!"
    ),
        
        
        
        
        
        
        
        
        
        
    )
    private String name;

}