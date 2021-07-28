package com.team404.command;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiUploadVO {

	private ArrayList<UploadVO> list;
}
