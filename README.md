coffeecan
=========

CoffeeCan is a Java library providing support for the [TinCan API][tincanapi]. It only provides a subset of the API
presently. It was written to serialize with Jackson and uses some JSR-303 validation. It also uses [Joda-Time][jodatime] for
time-based fields.

Simple Example
--------------

        Agent agent = new Agent();
        Account account = new Account("Sally Glider", "mailto:sally@example.com");
        agent.setAccount(account);

        Verb verb = new Verb(ADLVerbs.COMPLETED_ID);

        Activity activity = new Activity(ADLActivities.ASSESSMENT_ID);

        Statement statement = new Statement(agent, verb, activity);

        statement.setTimestamp(new DateTime());


Include Using Maven
-------------------

    <repositories>
        <repository>
            <id>allogy-maven-public</id>
            <name>Allogy public Maven release repository</name>
            <url>https://s3.amazonaws.com/allogy.maven.public/release</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.allogy.coffeecan</groupId>
            <artifactId>coffeecan</artifactId>
            <version>0.3</version>
        </dependency>
    </dependencies>

License
-------

Copyright (c) 2013 Allogy Interactive.

Released under the [Apache License, Version 2.0][apache-license].


[tincanapi]: http://tincanapi.com/developers/tech-overview
[apache-license]: http://www.apache.org/licenses/LICENSE-2.0
[jodatime]: http://joda-time.sourceforge.net
