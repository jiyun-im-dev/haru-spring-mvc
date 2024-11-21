package haru.spring.mvc.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import haru.spring.mvc.blog.vo.BlogListRequestVo;
import haru.spring.mvc.blog.vo.BlogListResponseVo;

@Mapper
public interface BlogMapper {
	@Delete("DELETE FROM TB_BLG_CONT WHERE BLG_CONT_SEQ = #{blgContSeq}")
	int delete(int blgContSeq);
	
	// namespace가 BlogMapper인 매퍼 XML(BlogMapper_SQL.xml)에서
	// id가 selectList인 statement를 실행
	// blogListRequestVo에 담긴 search 필드를 파라미터로 이용할 수 있다
	List<BlogListResponseVo> selectList(BlogListRequestVo blogListRequestVo);
}
