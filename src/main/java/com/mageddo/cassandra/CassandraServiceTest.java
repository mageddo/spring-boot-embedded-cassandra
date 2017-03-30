//package com.mageddo.cassandra;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//
//import org.apache.cassandra.service.StorageService;
//import org.apache.cassandra.thrift.Cassandra;
//import org.apache.cassandra.thrift.ColumnPath;
//import org.apache.cassandra.thrift.InvalidRequestException;
//import org.apache.cassandra.thrift.NotFoundException;
//import org.apache.cassandra.thrift.TimedOutException;
//import org.apache.cassandra.thrift.UnavailableException;
//import org.apache.thrift.TException;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.protocol.TProtocol;
//import org.apache.thrift.transport.TSocket;
//import org.apache.thrift.transport.TTransport;
//import org.apache.thrift.transport.TTransportException;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//public class CassandraServiceTest {
//
//    private static EmbeddedCassandraService cassandra;
//
//    /**
//     * Set embedded cassandra up and spawn it in a new thread.
//     *
//     * @throws TTransportException
//     * @throws IOException
//     * @throws InterruptedException
//     */
//    @BeforeClass
//    public static void setup() throws TTransportException, IOException,
//            InterruptedException {
//        // Tell cassandra where the configuration files are.
//        // Use the test configuration file.
//        System.setProperty("storage-config", "/tmp/conf");
//
//        StorageService.instance.initServer();
////        CassandraServiceDataCleaner cleaner = new CassandraServiceDataCleaner();
////        cleaner.prepare();
////        cassandra = new EmbeddedCassandraService();
////        cassandra.init();
////        Thread t = new Thread(cassandra);
////        t.setDaemon(true);
////        t.start();
//    }
//
//    @Test
//    public void testInProcessCassandraServer()
//            throws UnsupportedEncodingException, InvalidRequestException,
//            UnavailableException, TimedOutException, TException,
//            NotFoundException {
//        Cassandra.Client client = getClient();
//
//        String key_user_id = "1";
//
//        long timestamp = System.currentTimeMillis();
//        ColumnPath cp = new ColumnPath("Standard1");
//        cp.setColumn("name".getBytes("utf-8"));
//
//        // insert
//
////        client.exe
////        client.insert("Keyspace1", key_user_id, cp, "Ran".getBytes("UTF-8"),
////                timestamp, ConsistencyLevel.ONE);
////
////        // read
////        ColumnOrSuperColumn got = client.get("Keyspace1", key_user_id, cp,
////                ConsistencyLevel.ONE);
////
////        // assert
////        assertNotNull("Got a null ColumnOrSuperColumn", got);
////        assertEquals("Ran", new String(got.getColumn().getValue(), "utf-8"));
//    }
//
//    /**
//     * Gets a connection to the localhost client
//     *
//     * @return
//     * @throws TTransportException
//     */
//    private Cassandra.Client getClient() throws TTransportException {
//        TTransport tr = new TSocket("localhost", 9170);
//        TProtocol proto = new TBinaryProtocol(tr);
//        Cassandra.Client client = new Cassandra.Client(proto);
//        tr.open();
//        return client;
//    }
//}