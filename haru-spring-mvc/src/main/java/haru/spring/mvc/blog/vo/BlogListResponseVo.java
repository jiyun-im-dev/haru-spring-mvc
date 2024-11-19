package haru.spring.mvc.blog.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogListResponseVo {
	private int blgContSeq;
	private String title;
	private String contBdy;
	private LocalDateTime createDt;
	
	public String getFormattedCreateDt() {
		return this.createDt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
