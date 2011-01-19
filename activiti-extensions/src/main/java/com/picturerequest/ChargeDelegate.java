
package com.picturerequest;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.impl.el.Expression;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class ChargeDelegate implements org.activiti.engine.delegate.JavaDelegate
{
    private Expression wsdl;
    private Expression operation;
    private Expression parameters;
    private Expression returnValue;

    public void execute(DelegateExecution execution) throws Exception
    {
        String wsdlString = (String) wsdl.getValue(execution);

        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(wsdlString);

        ArrayList paramStrings = new ArrayList();
        if (parameters != null)
        {
            StringTokenizer st = new StringTokenizer((String) parameters.getValue(execution), ",");
            while (st.hasMoreTokens())
            {
                paramStrings.add(st.nextToken().trim());
            }
        }
        
        
        String operationName = (String) operation.getValue(execution);
        Object[] arguments = paramStrings.toArray(new Object[0]);
        
        Object response = client.invoke(operationName, arguments);
        if (returnValue != null)
        {
            String returnVariableName = (String) returnValue.getValue(execution);
            execution.setVariable(returnVariableName, response);
        }
    }
}
