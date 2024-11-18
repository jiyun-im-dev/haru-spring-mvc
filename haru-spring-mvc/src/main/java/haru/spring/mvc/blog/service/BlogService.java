package haru.spring.mvc.blog.service;

import java.util.Map;

import haru.spring.mvc.blog.vo.BlogEditRequestVo;

public interface BlogService {
	int create(Map<String, Object> map);

	Map<String, Object> read(int blogContSeq);

	boolean edit(BlogEditRequestVo blogEditRequestVo);

	boolean delete(int blogContSeq);
}
