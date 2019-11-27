package com.hx.hxhibernate.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hx.hxhibernate.entity.UserEntity;
import com.hx.hxhibernate.repository.UserRepository;
import com.hx.hxhibernate.service.UserService;

@Controller
@Component
public class UserAction {

	@Autowired
	public UserService uServices;

	@RequestMapping("/demo")
	@ResponseBody
	public String orm() {
		List<UserEntity> list = uServices.listDatas();
		StringBuffer sbf = new StringBuffer();
		sbf.append("总行数：" + uServices.getTotalCount() + " ");
		for (UserEntity entity : list) {
			sbf.append(entity.getId() + " ");
			sbf.append(entity.getCaption() + " ");
			sbf.append(entity.getPassword() + " ");
			sbf.append(entity.getCreateTime() + " ");
			sbf.append(entity.getUpdateTime() + "\n");
		}
		return sbf.toString();
	}

}
