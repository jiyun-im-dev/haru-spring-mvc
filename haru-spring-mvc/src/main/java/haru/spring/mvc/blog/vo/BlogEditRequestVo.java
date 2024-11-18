package haru.spring.mvc.blog.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogEditRequestVo {
	private int blogContSeq; // 블로그 컨텐츠 기본 키
	private String title;    // 컨텐츠 제목
	private String contBdy;  // 컨텐츠 내용
}