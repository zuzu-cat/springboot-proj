1. We should not have the entity annotations in courseDto.java since Dto classes represent POJO(plain old java objects) understood by the application instead of database entities 

2. Explicitly having all fetch types mapped to lazy or eager in the entity classes. Default fetch type will differ by version of Hibernate. For example in Hibernate 3.x, the default fetch type for @ManyToOne and @OneToOne associations was eager. In Hibernate 4.x and 5.x, the default fetch type for all associations is lazy.

3. We should add cacheing to our data fetches.

4. We should add auth check in the endpoints, for example oauth2. 

4. We shouldn't store PII in plain text, we should store the hashed passwords in our data.sql. 

5. We should have monitoring and logging. Specifically we can monitor CPU, disk, and memory usage. We should also be aware of API response time, throughput and also db performance like query performance. 

6. The storage of BC dates seems to be not working as in dates stored as "-427-08-01" gets converted to "0428-08-05" when read. We can resolve this with having an offset year of 1000 and make sure to add 1000 to the date when storing it and subtracting 1000 when displaying the data. Upon further investigation it seems that the data is getting put into the db correctly via checking "http://localhost:8080/h2-console". So its when we're casting the data as Localdate it get's corrupt. Changing it to string will fix this.

7. The tests seem to suffer from flakiness for some reason when using LocalDate. Even though localDate is suppose to be static and not differ based on timezones. When removing tz from the ci one test fails due to wrong date. Finally fixed all this date issue by simply reading the date from db as String instead of LocalDate.

8. student and teacher are basically the same entity, we could change it, but ultimatly because there's a circular dependency between course and teachers since courses api returns teacher info but not student info

