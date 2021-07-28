package com.team404.reply.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.team404.command.FreeReplyVO;
import com.team404.util.Criteria;

public interface ReplyMapper {
	
	public int regist(FreeReplyVO vo); //등록
//	public ArrayList<FreeReplyVO> getList(int bno);
	public ArrayList<FreeReplyVO> getList(@Param("bno") int bno, @Param("cri") Criteria cri);
	public int getTotal(int bno); //전체댓글 수
	
	public int pwCheck(FreeReplyVO vo);  //비밀번호 확인
	public int update(FreeReplyVO vo); //수정
}
