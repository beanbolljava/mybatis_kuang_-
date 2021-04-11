package dao;

import com.lts.dao.userMapper;
import com.lts.pojo.user;
import com.lts.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;


public class userMapperTest {

    static Logger logger= Logger.getLogger(userMapperTest.class);

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
    public void textbylog4j(){
        logger.info("info:进入了textbylog4j");
        logger.debug("info:进入了textbylog4j");
        logger.error("error");
    }
}
