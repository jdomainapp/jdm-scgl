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
import org.jda.example.coursemanrestful.modules.coursemodule.model.CompulsoryModule;
import org.jda.example.coursemanrestful.modules.coursemodule.ModuleCourseModule;

@ModuleDescriptor(
    name = "ModuleCompulsoryModule",
    modelDesc = @ModelDesc(
        model = CompulsoryModule.class
    ),
    viewDesc = @ViewDesc(
        formTitle = "Manage Compulsory Module",
        domainClassLabel = "Compulsory Module",
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
        
    },
    type = ModuleType.DomainData,
    isPrimary = true,
    modelDesc = @ModelDesc(
        model = CompulsoryModule.class
    )
    
)
public class ModuleCompulsoryModule extends ModuleCourseModule  {
        
            @AttributeDesc(
        label = "Form: Compulsory Module",  
        
        
        
        
        
        
        
        
        
        
    )
    private String title;

}