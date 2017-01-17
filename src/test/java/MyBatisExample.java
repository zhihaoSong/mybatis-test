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
            System.out.println(role.toString());
            roleMapper.addRoleGEKeys(role);
            //roleMapper.addRoleParam("song先生","好人啊");
            Role role1= roleMapper.getRole(11l);
            roleMapper.deleteRole(1L);
            sqlSession.commit();
            System.out.println(role1);
            System.out.println(role.toString());

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