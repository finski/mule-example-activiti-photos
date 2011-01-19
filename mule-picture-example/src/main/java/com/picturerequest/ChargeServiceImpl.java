/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.picturerequest;

import javax.jws.WebService;

@WebService(endpointInterface = "com.picturerequest.ChargeService", serviceName = "ChargeService")
public class ChargeServiceImpl implements ChargeService
{

    public String chargeAccount(String username, String imageName)
    {
        System.out.println(imageName);
        //do some stuff to charge the username
        return imageName;
    }
}


