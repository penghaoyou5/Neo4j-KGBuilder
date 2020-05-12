package com.warmer.kgmaker;/**
 * Created by penghaoyou on 2020-05-12
 */

import com.warmer.kgmaker.util.Neo4jConfig;
import com.warmer.kgmaker.util.Neo4jUtil;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

/**
 * @program kgmaker
 *
 * @description
 *
 * @author penghaoyou
 *
 * @date 2020-05-12 08:20
 **/
public class TestNeo4jDrive {
    public static void main(String[] args){
        Neo4jUtil neo4jUtil = new Neo4jUtil();
        Driver driver = new Neo4jConfig().neo4jDriver();
        Session session = driver.session();
        Result run = session.run("MATCH (n:`Movie`)  RETURN distinct(n) limit 100");
//        session.close();
        if (run.hasNext()) {
            System.out.println("jaj");
        }
        run.list().forEach(record -> {
            record.values().forEach(value -> {
                System.out.println(value);
            });
        });
    }
}
