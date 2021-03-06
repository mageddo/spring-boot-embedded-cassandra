package com.mageddo.cassandra;

import java.util.List;
import java.util.UUID;

import com.mageddo.CassandraConfig;
import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.CqlTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CassandraConfig.class })
@EmbeddedCassandra(timeout = 120000 )
@TestExecutionListeners(listeners = {
    CassandraUnitDependencyInjectionTestExecutionListener.class, DependencyInjectionTestExecutionListener.class
})
@CassandraDataSet(value = {"cql/baseData.cql"}, keyspace = "idoc")
public class CassandraBasicCrudTest {

    @Autowired
    private CqlTemplate template;

    @Test
    public void createInsertSelectTest() throws Exception {

        final String id = "4d7d6cb4-ae80-4c0a-81fe-f92ad5496424";

        template.execute("CREATE TABLE x (id UUID, PRIMARY KEY(id) )");
        template.execute("INSERT INTO x (id) VALUES (" + id + ") ");
        final List<UUID> results = template.query("SELECT * FROM x", (item, n) -> {
            return item.get(0, UUID.class);
        });

        Assert.assertEquals(1, results.size());
        Assert.assertEquals(id, results.get(0).toString());
    }

    @Test
    public void createInsertSelectTest2() throws Exception {

        final String id = "4d7d6cb4-ae80-4c0a-81fe-f92ad5496424";

        template.execute("CREATE TABLE x (id UUID, PRIMARY KEY(id) )");
        template.execute("INSERT INTO x (id) VALUES (" + id + ") ");
        final List<UUID> results = template.query("SELECT * FROM x", (item, n) -> {
            return item.get(0, UUID.class);
        });

        Assert.assertEquals(1, results.size());
        Assert.assertEquals(id, results.get(0).toString());
    }

}