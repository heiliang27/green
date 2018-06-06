package com.green.common.base.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.green.common.base.biz.BaseBiz;
import com.green.common.base.msg.ObjectRestResponse;
import com.green.common.base.msg.TableResultResponse;
import com.green.common.util.Query;

public class BaseController<Biz extends BaseBiz, Entity> {

	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected Biz baseBiz;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ObjectRestResponse<Entity> add(@RequestBody Entity entity) {
		baseBiz.insertSelective(entity);
		return new ObjectRestResponse<Entity>();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ObjectRestResponse<Entity> get(@PathVariable int id) {
		ObjectRestResponse<Entity> entityObjectRestResponse = new ObjectRestResponse<>();
		Object o = baseBiz.selectById(id);
		entityObjectRestResponse.data((Entity) o);
		return entityObjectRestResponse;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ObjectRestResponse<Entity> update(@RequestBody Entity entity) {
		baseBiz.updateSelectiveById(entity);
		return new ObjectRestResponse<Entity>();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ObjectRestResponse<Entity> remove(@PathVariable int id) {
		baseBiz.deleteById(id);
		return new ObjectRestResponse<Entity>();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Entity> all() {
		return baseBiz.selectListAll();
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	@ResponseBody
	public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		return baseBiz.selectByQuery(query);

	}

	public String getCurrentUserName() {
		// TODO 修改
		return null;//BaseContextHandler.getUsername();
	}
}
