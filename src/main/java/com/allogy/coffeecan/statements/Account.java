/*
 * Copyright (c) 2013 Allogy Interactive.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.allogy.coffeecan.statements;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.constraints.NotNull;

public class Account
{
    private final String name;
    private final String homePage;

    /**
     * Constructs an online account
     * @param name the agent's account name
     * @param homePage the service provider's homepage
     */
    public Account(@JsonProperty("name") String name,
                   @JsonProperty("homePage") String homePage)
    {
        this.name = name;
        this.homePage = homePage;
    }

    /**
     * Indicates the name (identifier) associated with this online account.
     * @return the agent's account name
     */
    @NotNull
    public String getName()
    {
        return name;
    }

    /**
     * Indicates a homepage of the service provider for this online account.
     * @return the service provider's homepage
     */
    @NotNull
    public String getHomePage()
    {
        return homePage;
    }
}
