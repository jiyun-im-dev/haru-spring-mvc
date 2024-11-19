package haru.spring.mvc.blog.vo;

public class BlogEditRequestVo {
	private int blogContSeq; // 블로그 컨텐츠 기본 키
	private String title;    // 컨텐츠 제목
	private String contBdy;  // 컨텐츠 내용
	
	public int getBlogContSeq() {
		return blogContSeq;
	}
	public void setBlogContSeq(int blogContSeq) {
		this.blogContSeq = blogContSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContBdy() {
		return contBdy;
	}
	public void setContBdy(String contBdy) {
		this.contBdy = contBdy;
	}
}