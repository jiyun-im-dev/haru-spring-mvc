package haru.spring.mvc.blog.vo;

import lombok.Getter;
import lombok.Setter;

// Data Access Layer (Repository Layer)
@Getter
@Setter
public class CommentInsertVo {
	// 추가할 댓글의 데이터를 담고 있다
	private int blgCmtSeq;  // 댓글 번호
	private int blgContSeq; // 블로그 컨텐츠 번호
	private String cmtBdy;  // 댓글 내용
	private String tmpPw;   // 댓글 임시 비밀번호
}