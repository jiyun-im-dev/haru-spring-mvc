package haru.spring.mvc.blog.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haru.spring.mvc.blog.dao.BlogDao;
import haru.spring.mvc.blog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
	
	private BlogDao blogDao;

	@Autowired
	public BlogServiceImpl(BlogDao blogDao) {
		this.blogDao = blogDao;
	}
	
	@Override
	public int create(Map<String, Object> map) {
		return this.blogDao.insert(map);
	}

	@Override
	public Map<String, Object> read(int blogContSeq) {
		// 기본 키를 매개변수로 넘기면 DAO에서 쿼리를 실행해 해당하는 객체를 찾아 리턴한다
		return this.blogDao.selectOne(blogContSeq);
	}
}