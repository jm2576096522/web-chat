package com.wys.chats.flock.service.impl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wys.chats.core.PageBean;
import com.wys.chats.core.PageDaoHelper;
import com.wys.chats.core.Request;
import com.wys.chats.entity.TbFlockMessage;
import com.wys.chats.flock.dao.TbFlockMessageDao;
import com.wys.chats.flock.service.TbFlockMessageService;
import com.wys.chats.util.JsonUtil;
import com.wys.chats.util.SysLog;

/**
* 
*
* Created by wangyanshu on '2018-05-18 00:05:06'.
*/
@Service
public class TbFlockMessageServiceImpl implements TbFlockMessageService {

	@Resource
	private TbFlockMessageDao tbFlockMessageDao;

	/**
    * 新增
    */
	@Override
	public int insert(TbFlockMessage tbFlockMessage) {
		try {
			if (tbFlockMessage == null) {
				return 0;
	        }
	        return tbFlockMessageDao.insert(tbFlockMessage);
		} catch (Exception e) {
			SysLog.error("新增service:---"+e);
			return 0;
		}
	}

	/**
	* 删除
	*/
	@Override
	public int delete(int id) {
		try {
			return tbFlockMessageDao.delete(id);
		} catch (Exception e) {
			SysLog.error("删除service:---"+e);
			return 0;
		}
	}

	/**
	* 更新
	*/
	@Override
	public int update(TbFlockMessage tbFlockMessage) {
		try {
			return tbFlockMessageDao.update(tbFlockMessage);
		} catch (Exception e) {
			SysLog.error("更新service:---"+e);
			return 0;
		}
	}

	/**
	* Load查询
	*/
	@Override
	public TbFlockMessage load(TbFlockMessage tbFlockMessage) {
		try {
			return tbFlockMessageDao.load(tbFlockMessage);
		} catch (Exception e) {
			SysLog.error("Load查询service:---"+e);
			return null;
		}
	}

	/**
	* 分页查询
	*/
	@Override
	public PageBean pageList(Request request) {
		Map<String, Object> paramMap = null;
		try {
			if(request.getData() != null && !request.getData().trim().equals("")){
				paramMap = JsonUtil.getMapFromJsonObjStr(request.getData());
			}
			return PageDaoHelper.search(tbFlockMessageDao, paramMap, request.getCurrPage(), request.getPageSize());
		} catch (Exception e) {
			SysLog.error("分页查询service:---"+e);
			return null;
		}
	}

}
