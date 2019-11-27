package com.hx.hxhibernate.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hx.hxhibernate.entity.UserEntity;
import com.hx.hxhibernate.service.UserService;

@Controller
@Component
public class UserAction {

	@Autowired
	public UserService uServices;

	@RequestMapping("/demo")
	@ResponseBody
	public String orm() {
		List<UserEntity> list1 = uServices.listDatas();
		//PageRequest.of(0, 3, Sort.Direction.ASC, "id");
		// PageRequest.of(页号、一页行数、排序方式 、排序字段)，0页代表第1页
		Pageable pageable = PageRequest.of(0, 3);
		List<UserEntity> list2 = uServices.selectPlayer(null, pageable);
		StringBuffer sbf = new StringBuffer();
		sbf.append("总行数：" + uServices.getTotalCount() + " ");
		for (UserEntity entity : list1) {
			sbf.append("<pre>" + entity.getId() + " ");
			sbf.append(entity.getCaption() + " ");
			sbf.append(entity.getPassword() + " ");
			sbf.append(entity.getCreateTime() + " ");
			sbf.append(entity.getUpdateTime() + "</pre>");
		}
		sbf.append("<pre>----</pre>");
		for (UserEntity entity : list2) {
			sbf.append("<pre>" + entity.getId() + " ");
			sbf.append(entity.getCaption() + " ");
			sbf.append(entity.getPassword() + " ");
			sbf.append(entity.getCreateTime() + " ");
			sbf.append(entity.getUpdateTime() + "</pre>");
		}
		return sbf.toString();
	}

}
