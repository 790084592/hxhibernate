package com.hx.hxhibernate.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hx.hxhibernate.entity.DemoEntity;
import com.hx.hxhibernate.repository.DemoRepository;

@Controller
@Component
public class DemoAction {
	
	@Autowired 
	public DemoRepository drep;

	@RequestMapping("/demo")
	@ResponseBody
	public String orm() {
		long i = 3;
		List<DemoEntity> list = drep.findAll();
		return drep.findById("3").getCaption();
	}

}
