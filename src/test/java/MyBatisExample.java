import com.szh.mapper.RoleMapper;
import com.szh.po.Role;
import com.szh.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class MyBatisExample {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("testName1");
            role.setNote("note1");
            roleMapper.addRole(role);
            roleMapper.deleteRole(1L);
            sqlSession.commit();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}