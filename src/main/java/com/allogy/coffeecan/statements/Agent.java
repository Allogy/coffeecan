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

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;

public class Agent extends Actor
{
    public static final String OBJECT_TYPE = "Agent";
    @Deprecated
    public static final String ObjectType = OBJECT_TYPE;

    private String name;
    @JsonProperty("mbox")
    private String mailbox;

    @Valid
    private Account account;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @JsonProperty("mbox")
    public String getMailbox()
    {
        return mailbox;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }
}
