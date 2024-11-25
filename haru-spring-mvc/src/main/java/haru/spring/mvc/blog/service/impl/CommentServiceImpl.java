package haru.spring.mvc.blog.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haru.spring.mvc.blog.mapper.CommentMapper;
import haru.spring.mvc.blog.service.CommentService;
import haru.spring.mvc.blog.vo.CommentAddRequestVo;
import haru.spring.mvc.blog.vo.CommentInsertVo;
import haru.spring.mvc.blog.vo.CommentResponseVo;

@Service
public class CommentServiceImpl implements CommentService {
	// 서비스는 DAO(가 매퍼 XML을 호출), 매퍼 인터페이스와 같은 Data Access Layer와 상호작용
	private CommentMapper commentMapper;

	// 생성자 주입(Constructor Injection) 방식을 사용. 생성자가 하나일 땐 @Autowired 생략 가능
	@Autowired
	public CommentServiceImpl(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}
	
	@Override
	public CommentResponseVo add(CommentAddRequestVo commentAddRequestVo) {
		ModelMapper modelMapper = new ModelMapper();
		// commentAddRequestVo(또는 DTO)를 CommentInsertVo 타입 객체(엔티티)로 매핑한다
		// commentAddRequestVo의 데이터가 ModelMapper에 의해 자동으로 commentInsertVo에 담긴다
		CommentInsertVo commentInsertVo = modelMapper.map(
				commentAddRequestVo, CommentInsertVo.class);
		
		// 임시 비밀번호 암호화
		if (commentInsertVo.getTmpPw() != null) {
			String sha256Hex = DigestUtils.sha256Hex(commentInsertVo.getTmpPw());
			commentInsertVo.setTmpPw(DigestUtils.sha256Hex(commentInsertVo.getTmpPw());
		}
		
		int affectedRowCount = this.commentMapper.insert(commentInsertVo);
		
		if (affectedRowCount == 0) {
	        return null;
	    }
		
		ModelMapper modelMapperInsertToResponse = new ModelMapper();
		// 댓글 추가 DTO(VO)를 댓글 응답 객체(엔티티?)로 매핑한다
		// commentInsertVo에 담긴 데이터를 setter를 이용해서 일일이 commentResponseVo에 담아줄 필요가 없다
		CommentResponseVo commentResponseVo = modelMapperInsertToResponse.map(
				commentInsertVo, CommentResponseVo.class);
		
		return commentResponseVo;
	}
}
