package com.hx.hxhibernate.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hx.hxhibernate.entity.UserEntity;
import com.hx.hxhibernate.repository.UserRepository;

@Controller
@Component
public class DemoAction {

	@Autowired
	public UserRepository urep;

	@RequestMapping("/demo")
	@ResponseBody
	public String orm() {
		// urep.save(new UserEntity("xs", "xsn", "xsc"));
		List<UserEntity> list = urep.findAll();
		StringBuffer sbf = new StringBuffer();
		sbf.append("总行数：" + urep.count() + " ");
		for (UserEntity entity : list) {
			sbf.append(entity.getId() + " ");
			sbf.append(entity.getCaption() + " ");
			sbf.append(entity.getCreateTime() + " ");
			sbf.append(entity.getUpdateTime() + "\n");
		}
		return sbf.toString();
	}

}
