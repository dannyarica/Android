package com.hintdesk.De_De_Dict.contract.util.database.migrations;


import com.hintdesk.core.CoreConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 5/31/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Migration {
    protected List<String> steps;

    public Migration() {
        this.steps = new ArrayList<String>();
    }

    public String getSQLQuery()
    {
        StringBuilder result = new StringBuilder();
        for(String step:steps)
        {
            result.append(step + ";" + CoreConstants.ENVIRONMENT_NEWLINE);
        }
        return result.toString();
    }
}
