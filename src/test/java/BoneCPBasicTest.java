import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import org.apache.ibatis.io.Resources;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static org.apache.ibatis.io.Resources.getResourceAsFile;

/**
 * Created by zhihaosong on 17-1-12.
 */
public class BoneCPBasicTest {
    private static BoneCP connectionPool = null;
    private static BoneCPBasicTest instance = null;
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    public static BoneCPBasicTest getInstance() {
        if (instance == null) {
            synchronized (BoneCPBasicTest.class) {
                if (instance == null) {
                    instance = new BoneCPBasicTest();
                }
            }
        }
        return instance;
    }

    public void init() {
        try {
            String filePath = Resources.getResourceAsFile("database.properties").getAbsolutePath();
            //  String filePath = BoneCPBasicTest.class.getResource("/").getPath() + "database.properties";
            Properties props = new Properties();
            InputStream in = null;
            in = new BufferedInputStream(new FileInputStream(filePath));
            props.load(in);
            driver = props.getProperty("jdbc.driver");
            url = props.getProperty("jdbc.connectionURL");
            user = props.getProperty("jdbc.user");
            password = props.getProperty("jdbc.pwd");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public BoneCPBasicTest() {
        init();
        try {
            Class.forName(driver);    // load the DB driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //设置连接池配置信息
        BoneCPConfig config = new BoneCPConfig();
        //数据库的JDBC URLdbs.urlMail=jdbc:mysql://172.20.10.1:3308/DB_MAIL?autoCommit=true&autoReconnect=true&useUnicode=true&tinyInt1isBit=false&zeroDateTimeBehavior=round&characterEncoding=UTF-8&yearIsDateType=false&zeroDateTimeBehavior=convertToNull

        config.setJdbcUrl(url);
        //数据库用户名
        config.setUsername(user);
        //数据库用户密码
        config.setPassword(password);
        //数据库连接池的最小连接数
        config.setMinConnectionsPerPartition(5);
        //数据库连接池的最大连接数
        config.setMaxConnectionsPerPartition(10);
        config.setConnectionTestStatement("SELECT 1");
        config.setPartitionCount(1);
        //加入此项配置用来解决MySQL可能发生联机超时(SQLState = 08S01)的问题
        config.setIdleConnectionTestPeriod(1);
        config.setStatementsCacheSize(10);
        //设置数据库连接池
        try {
            connectionPool = new BoneCP(config);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public BoneCP getConnectionPool() {
        return connectionPool;
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = BoneCPBasicTest.getInstance().getConnectionPool().getConnection();    // fetch a connection
            if (connection != null) {
                System.out.println("Connection successful!");
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(" select * from t_role "); // do something with the connection.
                while (rs.next()) {
                    System.out.println(rs.getString(1)); // should print out "1"'
                    System.out.println(rs.getString(2)); // should print out "1"'
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();                // close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connectionPool.shutdown();            // close the connection pool

        }
    }
}
