package haru.spring.mvc.blog.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import haru.spring.mvc.blog.vo.BlogEditRequestVo;

@Repository
public class BlogDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
	    int result = this.sqlSessionTemplate.insert("TB_BLG_CONT.insert", map);
	    if (result > 0 && map.containsKey("seq_blg_cont")) {
	    	// 데이터 삽입에 성공하면 해당 데이터의 기본 키를 리턴
	        return (Integer) map.get("seq_blg_cont");
	    }
	    
	    // 데이터 삽입에 실패한 경우
	    return -1;
	}
	
	public int update(BlogEditRequestVo blogEditRequestVo) {
		// update 메서드도 insert 메서드처럼 영향받은 행 수를 반환
		return this.sqlSessionTemplate.update("TB_BLG_CONT.update", blogEditRequestVo);
	}

	// 서비스가 DAO를 호출하면 DAO는 쿼리(매퍼 XML)를 실행해서 결과값을 서비스로 전달한다
	// 컨트롤러 → 서비스 → DAO 또는 매퍼 인터페이스 → 매퍼 XML로 파라미터가 전달된다  
	public Map<String, Object> selectOne(int blogContSeq) {
		return this.sqlSessionTemplate.selectOne("TB_BLG_CONT.selectOne", blogContSeq);
	}
}