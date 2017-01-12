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
            role.setRoleName("宋志豪");
            role.setNote("note1");
            roleMapper.addRole(role);
            //roleMapper.addRoleParam("song先生","好人啊");
            roleMapper.findRoleByAnnotation("song先生","好人啊");
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