package haru.spring.mvc.blog.service;

import java.util.List;
import java.util.Map;

import haru.spring.mvc.blog.vo.BlogEditRequestVo;
import haru.spring.mvc.blog.vo.BlogListRequestVo;
import haru.spring.mvc.blog.vo.BlogListResponseVo;

public interface BlogService {
	int create(Map<String, Object> map);

	Map<String, Object> read(int blogContSeq);

	boolean edit(BlogEditRequestVo blogEditRequestVo);

	boolean delete(int blogContSeq);

	List<BlogListResponseVo> list(BlogListRequestVo blogListRequestVo);
}
