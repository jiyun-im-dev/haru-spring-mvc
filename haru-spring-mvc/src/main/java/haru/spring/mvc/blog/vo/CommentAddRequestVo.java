package haru.spring.mvc.blog.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentAddRequestVo {
	private int blgContSeq; // 댓글을 작성할 글 번호
	private String cmtBdy;  // 댓글 내용
	private String tmpPw;  // 댓글 임시 비밀번호
}
