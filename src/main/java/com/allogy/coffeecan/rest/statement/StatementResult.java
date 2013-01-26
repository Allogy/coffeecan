package com.allogy.coffeecan.rest.statement;

import com.allogy.coffeecan.statements.Statement;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The result object of a query to the XAPI Statement API.
 */
public class StatementResult
{
    private List<Statement> statements;
    private String moreURL;

    /**
     * @return a list of Statements
     */
    public List<Statement> getStatements()
    {
        return statements;
    }

    /**
     * @param statements a list of Statements
     */
    public void setStatements(List<Statement> statements)
    {
        this.statements = statements;
    }

    /**
     * @return a URL to retrieve additional results
     */
    @JsonProperty("more")
    public String getMoreURL()
    {
        return moreURL;
    }

    /**
     * @param moreURL a URL to retrieve additional results
     */
    @JsonProperty("more")
    public void setMoreURL(String moreURL)
    {
        this.moreURL = moreURL;
    }
}
