package org.jda.example.coursemanrestful.modules.address;

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
import jda.mosa.controller.*;
import jda.mosa.view.assets.datafields.list.JComboField;
import jda.mosa.view.assets.panels.DefaultPanel;
import jda.mosa.view.View;
import org.jda.example.coursemanrestful.modules.address.model.Address;
import org.jda.example.coursemanrestful.modules.student.model.Student;

@ModuleDescriptor(
    name = "ModuleAddress",
    modelDesc = @ModelDesc(
        model = Address.class
    ),
    viewDesc = @ViewDesc(
        formTitle = "Form: Address",
        domainClassLabel = "Address",
        imageIcon = "Address.png",
        view = View.class,
        viewType = RegionType.Null,
        parent = RegionName.Null,
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
        controller = ControllerBasic.class,
        openPolicy = OpenPolicy.I,
        isDataFieldStateListener = false
    ),
    setUpDesc = @SetUpDesc(),
    subtypes = {
        
    },
    type = ModuleType.DomainData,
    isPrimary = false,
    modelDesc = @ModelDesc(
        model = Address.class
    )
    
)
public class ModuleAddress  {
        
            @AttributeDesc(
        label = "ID",  
        
        
        
        
        
        
        
        
        
        
    )
    private int id;
        
            @AttributeDesc(
        label = "Student",  
        
        
        
        
        
        
        
        
        
        
    )
    private Student student;
        
            @AttributeDesc(
        label = "Form: Address",  
        
        
        
        
        
        
        
        
        
        
    )
    private String title;
        
            @AttributeDesc(
        label = "City name",  
        
        
        
        
        
        
        
        
        
        
    )
    private String name;

}