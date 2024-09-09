package org.jda.example.coursemanrestful.modules.studentclass;

import java.util.List;
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
import org.jda.example.coursemanrestful.modules.student.model.Student;
import org.jda.example.coursemanrestful.modules.studentclass.model.StudentClass;

@ModuleDescriptor(
    name = "ModuleStudentClass",
    modelDesc = @ModelDesc(
        model = StudentClass.class
    ),
    viewDesc = @ViewDesc(
        formTitle = "Manage Student Classes",
        domainClassLabel = "Student Class",
        imageIcon = "sclass.png",
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
        openPolicy = OpenPolicy.O_C,
        isDataFieldStateListener = false
    ),
    setUpDesc = @SetUpDesc(
        postSetUp = CopyResourceFilesCommand.class
    ),
    subtypes = {
        
    },
    type = ModuleType.DomainData,
    isPrimary = true,
    modelDesc = @ModelDesc(
        model = StudentClass.class
    )
    
)
public class ModuleStudentClass  {
        
            @AttributeDesc(
        label = "Name",  
        
        
        
        
        
        
        
        
        
        
    )
    private String name;
        
            @AttributeDesc(
        label = "Student Class",  
        
        
        
        
        
        
        
        
        
        
    )
    private String title;
        
            @AttributeDesc(
        label = "Id",  
        
        
        
        
        
        
        
        
        
        
    )
    private int id;
        
            @AttributeDesc(
        label = "Gender",  
        
        type = DefaultPanel.class,
        
        
        
        
        
        
        
        
    )
    private List<Student> students;

}