package haru.spring.mvc.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haru.spring.mvc.blog.mapper.CommentMapper;
import haru.spring.mvc.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	// 서비스는 DAO, Mapper와 같은 Data Access Layer와 상호작용
	private CommentMapper commentMapper;

	// 생성자 주입(Constructor Injection) 방식을 사용. 생성자가 하나일 땐 @Autowired 생략 가능
	@Autowired
	public CommentServiceImpl(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}
}
