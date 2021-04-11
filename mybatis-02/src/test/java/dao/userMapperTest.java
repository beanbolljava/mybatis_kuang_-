package dao;

import com.lts.dao.userMapper;
import com.lts.pojo.user;
import com.lts.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class userMapperTest {
    @Test
    public void text() {
        //获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //执行sql
            userMapper userMapper = sqlSession.getMapper(userMapper.class);
            List<user> userList = userMapper.getuserList();
            for (user user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlsession
            sqlSession.close();
        }


    }

    @Test
    public void textbyid() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            userMapper userMapper = sqlSession.getMapper(userMapper.class);
            user user = userMapper.getuserbyid(41);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void textadd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userMapper userMapper = sqlSession.getMapper(userMapper.class);
        int s = userMapper.adduser(new user(1, "康熙", new Date(), "男", "故宫"));
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void textupdate() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userMapper userMapper = sqlSession.getMapper(userMapper.class);
        int s = userMapper.updatede(new user(1, "顺治", new Date(), "男", "故宫"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void textdeletd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userMapper userMapper = sqlSession.getMapper(userMapper.class);
        int s = userMapper.deletet(1);
        sqlSession.commit();
        sqlSession.close();
    }
}
