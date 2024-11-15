package haru.spring.mvc.blog.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
	    int result = this.sqlSessionTemplate.insert("TB_BLG_CONT.insert", map);
	    if (result > 0 && map.containsKey("seq_blg_cont")) {
	        return (Integer) map.get("seq_blg_cont");
	    }
	 
	    return -1;
	}

	public Map<String, Object> selectOne(int blogContSeq) {
		return this.sqlSessionTemplate.selectOne("TB_BLG_CONT.selectOne", blogContSeq);
	}
}