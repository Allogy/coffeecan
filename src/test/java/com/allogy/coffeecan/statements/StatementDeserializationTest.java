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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import static com.allogy.coffeecan.statements.LoadFromFileHelper.loadResource;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class StatementDeserializationTest
{
    private ObjectMapper objectMapper;

    @Before
    public void setUp()
    {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void jackson_is_able_to_deserialize_the_example_from_TinCan_Statements_101_tutorial() throws IOException
    {
        InputStream jsonInputStream = loadResource("TinCanStatements101Example");

        Statement statement = objectMapper.readValue(jsonInputStream, Statement.class);

        assertThat(statement, notNullValue());

        assertThat(statement.getActor(), notNullValue());
        assertThat(statement.getActor(), instanceOf(Agent.class));
        Agent agent = (Agent) statement.getActor();
        assertThat(agent.getName(), is("Sally Glider"));
        assertThat(agent.getMailbox(), is("mailto:sally@example.com"));

        assertThat(statement.getVerb(), notNullValue());
        assertThat(statement.getVerb().getID(), is("http://adlnet.gov/expapi/verbs/experienced"));
        assertThat(statement.getVerb().getDisplay(), notNullValue());
        assertThat(statement.getVerb().getDisplay().size(), is(1));
        assertThat(statement.getVerb().getDisplay().get("en-US"), is("experienced"));

        assertThat(statement.getObject(), notNullValue());
        assertThat(statement.getObject(), instanceOf(Activity.class));
        Activity activity = (Activity) statement.getObject();
        assertThat(activity.getID(), is("http://example.com/activities/solo-hang-gliding"));
        assertThat(activity.getDefinition(), notNullValue());
        assertThat(activity.getDefinition().getName(), notNullValue());
        assertThat(activity.getDefinition().getName().size(), is(1));
        assertThat(activity.getDefinition().getName().get("en-US"), is("Solo Hang Gliding"));
    }

    @Test
    public void jackson_is_able_to_deserialize_the_example_from_TinCan_Statements_101_tutorial_with_an_account() throws IOException
    {
        InputStream jsonInputStream = loadResource("TinCanAPIExampleAccount");

        Statement statement = objectMapper.readValue(jsonInputStream, Statement.class);

        assertThat(statement, notNullValue());

        assertThat(statement.getActor(), notNullValue());
        assertThat(statement.getActor(), instanceOf(Agent.class));
        Agent agent = (Agent) statement.getActor();
        assertThat(agent.getName(), is("Sally Glider"));
        assertThat(agent.getAccount(), notNullValue());
        assertThat(agent.getAccount().getName(), is("1625378"));
        assertThat(agent.getAccount().getHomePage(), is("http://www.example.com"));

        assertThat(statement.getVerb(), notNullValue());
        assertThat(statement.getVerb().getID(), is("http://adlnet.gov/expapi/verbs/experienced"));
        assertThat(statement.getVerb().getDisplay(), notNullValue());
        assertThat(statement.getVerb().getDisplay().size(), is(1));
        assertThat(statement.getVerb().getDisplay().get("en-US"), is("experienced"));

        assertThat(statement.getObject(), notNullValue());
        assertThat(statement.getObject(), instanceOf(Activity.class));
        Activity activity = (Activity) statement.getObject();
        assertThat(activity.getID(), is("http://example.com/activities/solo-hang-gliding"));
        assertThat(activity.getDefinition(), notNullValue());
        assertThat(activity.getDefinition().getName(), notNullValue());
        assertThat(activity.getDefinition().getName().size(), is(1));
        assertThat(activity.getDefinition().getName().get("en-US"), is("Solo Hang Gliding"));
    }

    @Test
    public void jackson_is_able_to_deserialize_the_example_from_TinCan_Statements_101_tutorial_with_a_result() throws IOException
    {
        InputStream jsonInputStream = loadResource("TinCanStatements101ExampleResult");

        Statement statement = objectMapper.readValue(jsonInputStream, Statement.class);

        assertThat(statement, notNullValue());

        assertThat(statement.getActor(), notNullValue());
        assertThat(statement.getVerb(), notNullValue());
        assertThat(statement.getObject(), notNullValue());

        assertThat(statement.getResult(), notNullValue());

        ResultScore score = statement.getResult().getScore();
        assertThat(score, notNullValue());
        assertThat(score.getScaled(), is(new BigDecimal("0.95")));
        assertThat(statement.getResult().getCompletion(), is(true));
        assertThat(statement.getResult().getSuccess(), is(true));
    }

    @Test
    public void jackson_is_able_to_deserialize_the_JSON_with_a_parent_context() throws IOException
    {
        InputStream jsonInputStream = loadResource("StatementWithParentContext");

        Statement statement = objectMapper.readValue(jsonInputStream, Statement.class);

        assertThat(statement, notNullValue());

        assertThat(statement.getActor(), notNullValue());
        assertThat(statement.getVerb(), notNullValue());
        assertThat(statement.getObject(), notNullValue());

        assertThat(statement.getContext(), notNullValue());

        assertThat(statement.getContext().getContextActivities(), notNullValue());

        assertThat(statement.getContext().getContextActivities().getParent(), notNullValue());

        assertThat(statement.getContext().getContextActivities().getParent().getID(), is("http://example.com/activities/hang-gliding-class-a"));
    }
}
