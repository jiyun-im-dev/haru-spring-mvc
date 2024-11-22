package haru.spring.mvc.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

import haru.spring.mvc.blog.vo.CommentInsertVo;

@Mapper
public interface CommentMapper {
	// 댓글 입력 값 객체를 받아 INSERT문 실행하고 영향받은 행 수를 반환
	int insert(CommentInsertVo commentInsertVo);
}
