
package com.picturerequest;

import java.util.HashSet;
import java.util.Set;

import org.activiti.engine.delegate.DelegateExecution;

public class NeedsApprovalDelegate implements org.activiti.engine.delegate.JavaDelegate
{

    private static Set<String> imagesWithCopyright = new HashSet<String>();
    
    static {
        imagesWithCopyright.add("mule1.jpg");
        imagesWithCopyright.add("mule2.jpg");
    }
    
    public void execute(DelegateExecution execution) throws Exception
    {
        String imageName = (String) execution.getVariable("imageName");
        boolean needsApproval = imagesWithCopyright.contains(imageName);
        execution.setVariable("needsApproval", needsApproval);
    }
}
