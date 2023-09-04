1. We should not have the entity annotations in courseDto.java since Dto classes represent POJO(plain old java objects) understood by the application instead of database entities 

2. Explicitly having all fetch types mapped to lazy or eager in the entity classes. Default fetch type will differ by version of Hibernate. For example in Hibernate 3.x, the default fetch type for @ManyToOne and @OneToOne associations was eager. In Hibernate 4.x and 5.x, the default fetch type for all associations is lazy.

3. We should add cacheing to our data fetches.

4. We should add auth check in the endpoints, for example oauth2. 

4. We shouldn't store PII in plain text, we should store the hashed passwords in our data.sql. 

5. We should have monitoring and logging. Specifically we can monitor CPU, disk, and memory usage. We should also be aware of API response time, throughput and also db performance like query performance. 

student and teacher are basically the same entity, we could change it, but ultimatly because there's a circular dependency between course and teachers since courses api returns teacher info but not student info

we should add monitoring 