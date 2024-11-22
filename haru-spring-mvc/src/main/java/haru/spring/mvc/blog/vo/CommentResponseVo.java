package haru.spring.mvc.blog.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseVo {
	private int blgCmtSeq; // 댓글 번호
	private String cmtBdy; // 댓글 내용
}
