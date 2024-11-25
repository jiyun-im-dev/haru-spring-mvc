package haru.spring.mvc.blog.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseVo { // 댓글 추가 요청에 응답하는 VO(?)
	private int blgCmtSeq; // 댓글 번호
	private String cmtBdy; // 댓글 내용
}
