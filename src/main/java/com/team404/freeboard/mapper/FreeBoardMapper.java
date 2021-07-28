package com.team404.freeboard.mapper;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;
import com.team404.util.Criteria;

public interface FreeBoardMapper {

	public int regist(FreeBoardVO vo); //등록
//	public ArrayList<FreeBoardVO> getList(); //조회
	public int getTotal(Criteria cri); //전체게시글 수
	
	public ArrayList<FreeBoardVO> getList(Criteria cri);
	
	public FreeBoardVO getDetail(int bno); //상세
	public int update(FreeBoardVO vo); //수정
	public int delete(int bno); //삭제
}
