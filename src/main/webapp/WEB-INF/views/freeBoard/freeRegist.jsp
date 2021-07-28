﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <section>
       <div class="container">
            <div class="row">
                <div class="col-xs-12 content-wrap">
                    <div class="titlebox">
                        <p>자유게시판</p>
                    </div>
                    <form action="registForm" method="post">
	                    <table class="table">
	                        <tbody class="t-control">
	                            <tr>
	                                <td class="t-title">NAME</td>
	                                <td><input class="form-control input-sm" name="writer" value="${sessionScope.userVO.userId }" readonly required></td>
	                            </tr>
	                            <tr>
	                                <td class="t-title">TITLE</td>
	                                <td><input class="form-control input-sm" name="title" required></td>
	                            </tr>
	                            <tr>
	                                <td class="t-title">COMMNET</td>
	                                <td>
	                                <textarea class="form-control" rows="7" name="content" required></textarea>
	                                </td>                 
	                            </tr>
	                        </tbody>
	                    </table>
	                    
	                    <div class="titlefoot">
	                        <button type="submit" class="btn" >등록</button>
	                        <button type="button" class="btn" onclick="location.href='freeList' ">목록</button>
	                    </div>
                    </form>
                    
                </div>
            </div>    
       </div>
    </section>
  