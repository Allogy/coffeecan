coffeecan
=========

CoffeeCan is a Java library providing support for the [TinCan API][tincanapi]. It only provides a subset of the API presently. It was written to serialize with Jackson and uses some JSR-303 validation.

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
