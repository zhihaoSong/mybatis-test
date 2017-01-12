
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import com.szh.mapper.RoleMapper;
import com.szh.mapper.RoleMapper2;
import com.szh.mapper.UserMapper;
import com.szh.po.Role;
import com.szh.po.Sex;
import com.szh.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "mybatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MyBatisTest.class.getClassLoader().getResourceAsStream(resource);
        // InputStream is = Resources.getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * com.szh.mapper.RoleMapper RoleMapper.xml文件中mapper标签的namespace属性的值，
         * getRole 是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        RoleMapper2 roleMapper = session.getMapper(RoleMapper2.class);
        Role role = roleMapper.getRole(1L);
        System.out.println(role);
        RoleMapper roleMapper1 = session.getMapper(RoleMapper.class);
        Role role2 = roleMapper1.getRoleToHandler(6L);
        System.out.println(role2);
/*        String statement = "userMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        Syste.out.println(user);*/
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("szg");
        user.setBirthday(new Date());
        user.setEmail("1551151530@qq.com");
        user.setMobile("18201090152");
        user.setCreate_date(new Date());
        user.setSex(Sex.MALE);
        user.setNote("你好测试是是否");
        userMapper.insertSelective(user);
        System.out.println(userMapper.selectByPrimaryKey(366));
        session.commit();
    }

}