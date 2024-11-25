package haru.spring.mvc.blog.service;

import haru.spring.mvc.blog.vo.CommentAddRequestVo;
import haru.spring.mvc.blog.vo.CommentResponseVo;

public interface CommentService {

	CommentResponseVo add(CommentAddRequestVo commentAddRequestVo);

}
