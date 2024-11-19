package haru.spring.mvc.blog.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {
	@Delete("DELETE FROM TB_BLG_CONT WHERE BLG_CONT_SEQ = #{blgContSeq}")
	int delete(int blgContSeq);
}
