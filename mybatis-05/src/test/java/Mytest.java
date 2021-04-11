import com.lts.dao.StudentMapper;
import com.lts.pojo.Student;
import com.lts.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mytest {
    @Test
    public void test(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentMapper mapper= sqlSession.getMapper(StudentMapper.class);

        List<Student> list=mapper.getstudent2();

        for (Student student : list) {
            System.out.println(student);
        }

        sqlSession.close();
    }

}
