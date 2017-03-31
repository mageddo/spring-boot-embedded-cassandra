package com.mageddo.cassandra;

import java.util.UUID;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.utils.UUIDs;
import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.cassandra.core.CqlTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CassandraConfig.class })
@EmbeddedCassandra(timeout = 60000  )
@CassandraDataSet(value = {"cql/baseData.cql"}, keyspace = "idoc")
@TestExecutionListeners(listeners = {  CassandraUnitDependencyInjectionTestExecutionListener.class,  DependencyInjectionTestExecutionListener.class  })
@DependsOn("cassandraConfig")
public class InboundDocumentCassandraDaoTest {

    @Autowired
    CqlTemplate cassOp;


    @Test
    public void insert_into_idocs() throws Exception {

        UUID id = UUIDs.timeBased();
        long addedDate = System.currentTimeMillis();

//        Insert insert = QueryBuilder.insertInto("idocs");
//        insert.setConsistencyLevel(com.datastax.driver.core.ConsistencyLevel.ONE);
//        insert.value("idoc_id", id);
//        insert.value("idoc_added_date", addedDate);
//        insert.value("idoc_type", "invoice");
//        insert.value("json_doc", "{ \"foo\":\"bar\" }");

//        cassOp.execute("CREATE TABLE \"x\" (\"id\" UUID, PRIMARY KEY(\"id\"));");

//        String jsonObj = dao.getInboundDocumentById(id.toString());
//        assertNotNull(jsonObj);
//        assertEquals("{ \"foo\":\"bar\" }", jsonObj);
    }

    @Configuration
    public static class CassandraPropertiesTest {
        @Bean
        public CassandraProperties cassadraProps() {
            CassandraProperties props = new CassandraProperties();
            props.setContactPoints("127.0.0.1");
            props.setPort(9142);
            props.setKeyspaceName("idoc");
            props.setConsistencyLevel(ConsistencyLevel.ONE);
            return props;
        }
    }
}