package com.team404.snsboard.service;

import java.util.ArrayList;

import com.team404.command.SnsBoardVO;

public interface SnsBoardService {

	public int insert(SnsBoardVO vo); //파일인서트
	public ArrayList<SnsBoardVO> getList();
	
}
