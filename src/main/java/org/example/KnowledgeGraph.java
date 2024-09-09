package org.example;

import org.neo4j.driver.*;
import org.neo4j.driver.Record;

import java.util.List;

public class KnowledgeGraph {
    private static Driver driver = null;
//    private static String URI = "neo4j+s://9336e8e4.databases.neo4j.io";
    private static String URI = "bolt://localhost:7687";
    private static String USER = "neo4j";
//    private static String PASSWORD = "Y2x8MhqmdQV7qe7cz2ON_0rc8M7noF7ZNiRppaxfds8";
    private static String PASSWORD = "courseman";

    public static void init() {
        driver = GraphDatabase.driver(URI, AuthTokens.basic(USER, PASSWORD));
    }

    public static List<Record> query(String query) throws NullPointerException {
        if (driver == null) {
            throw new NullPointerException("Knowledge graph is not initialized.");
        }

        var result = driver.executableQuery(query)
            .withConfig(QueryConfig.builder()
                .withDatabase("neo4j")
                .withRouting(RoutingControl.READ)
                .build())
            .execute();

        return result.records();
    }

    public static void close() {
        driver.close();
    }
}
