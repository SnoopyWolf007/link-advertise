package org.link.advertise.dot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.FormParam;

/**
 * @author jcm1024@163.com
 * @date 2020/7/17 11:28
 */
@RestController
@RequestMapping("/dot")
public class DotController {

	@RequestMapping("/push")
	public void push(@FormParam("data") String data) {
		//TODO 推入kafka
	}
}
