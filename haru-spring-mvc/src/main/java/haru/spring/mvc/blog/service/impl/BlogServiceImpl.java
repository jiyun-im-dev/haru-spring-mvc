package haru.spring.mvc.blog.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haru.spring.mvc.blog.dao.BlogDao;
import haru.spring.mvc.blog.mapper.BlogMapper;
import haru.spring.mvc.blog.service.BlogService;
import haru.spring.mvc.blog.vo.BlogEditRequestVo;
import haru.spring.mvc.blog.vo.BlogListRequestVo;
import haru.spring.mvc.blog.vo.BlogListResponseVo;

// 애노테이션에 의해 서비스 빈으로 등록되어 있다
@Service
public class BlogServiceImpl implements BlogService {
	
	private BlogDao blogDao;
	private BlogMapper blogMapper;

	// 생성자 주입(Constructor Injection) 방식을 사용. 생성자가 하나일 땐 @Autowired 생략 가능
	@Autowired
	public BlogServiceImpl(BlogDao blogDao, BlogMapper blogMapper) {
		this.blogDao = blogDao;
		this.blogMapper = blogMapper;
	}
	
	@Override
	public int create(Map<String, Object> map) {
		return this.blogDao.insert(map);
	}

	// 사용자가 읽기 요청한 글 번호가 컨트롤러에서 파라미터로 넘어온다
	// 서비스는 DAO 또는 매퍼 인터페이스를 호출한다
	@Override
	public Map<String, Object> read(int blogContSeq) {
		// 기본 키를 매개변수로 넘기면 DAO에서 쿼리를 실행해 해당하는 객체를 찾아 리턴한다
		return this.blogDao.selectOne(blogContSeq);
	}
	
	@Override
	public boolean edit(BlogEditRequestVo blogEditRequestVo) {
		int affectedRowsCount = blogDao.update(blogEditRequestVo);
		return affectedRowsCount > 0;
	}
	
	@Override
	public boolean delete(int blogContSeq) {
		// 삭제 성공 여부 반환
		return this.blogMapper.delete(blogContSeq) > 0;
	}
	
	@Override
	// 블로그 컨텐츠 응답 객체들의 리스트를 리턴
	public List<BlogListResponseVo> list(BlogListRequestVo blogListRequestVo) {
		return this.blogMapper.selectList(blogListRequestVo);
	}
}