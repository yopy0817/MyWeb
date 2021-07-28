package com.team404.reply.service;

import java.util.ArrayList;

import com.team404.command.FreeReplyVO;
import com.team404.util.Criteria;

public interface ReplyService {

	public int regist(FreeReplyVO vo); //등록
//	public ArrayList<FreeReplyVO> getList(int bno);
	public ArrayList<FreeReplyVO> getList(int bno, Criteria cri);
	public int getTotal(int bno); //전체댓글 수
	
	public int pwCheck(FreeReplyVO vo);  //비밀번호 확인
	public int update(FreeReplyVO vo); //수정
}
