package com.biz.ajax01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.ajax01.mapper.DeptMapper;
import com.biz.ajax01.model.DeptVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // 아주아주중요. 너는 service패키지라는걸 알려주는것
public class DeptService {
	
	@Autowired
	DeptMapper dMapper;
	List<DeptVO> dlist = new ArrayList<DeptVO>();

	public List<DeptVO> getDeptAllList() {
		
		return dMapper.selectAll();
	}

	public DeptVO getDept(String d_code) {
		
		DeptVO deptVO = dMapper.findByDCode(d_code);
		return deptVO;
	}

	public List<DeptVO> getFindByDName(String d_name) {
		log.debug(d_name);
		
		//앞뒤 빈칸제거
		return dMapper.findByDName(d_name.trim());
				}

	public int save(DeptVO deptVO) {
		
		
		int ret = 0;
		// 새로 등록이냐 아니면 수정(Update)등록이냐
		
		String d_code = deptVO.getD_code();
		DeptVO tvo =  dMapper.findByDCode(d_code);
		if(tvo ==null) {
			ret = dMapper.insert(deptVO);
		}else {
			ret = dMapper.update(deptVO);
		}
		return ret;
	}
	
	
	
}
