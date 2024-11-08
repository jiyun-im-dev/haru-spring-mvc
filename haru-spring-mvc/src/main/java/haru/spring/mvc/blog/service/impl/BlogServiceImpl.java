package haru.spring.mvc.blog.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import haru.spring.mvc.blog.dao.BlogDao;
import haru.spring.mvc.blog.service.BlogService;

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

}
