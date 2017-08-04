package com.huiwan.gdata.modules.gdata.cat;

import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huiwan.gdata.common.bean.ResultBean;
import com.huiwan.gdata.common.utils.pagination.Paginator;
import com.huiwan.gdata.common.utils.web.EmailUtil;
import com.huiwan.gdata.modules.gdata.cat.bean.EmailBean;

/**
 * cat 相关服务
 * 
 * @author rui
 *
 */
@Controller
@RequestMapping("cat/send")
public class SendController {

	/**
	 * 邮件发送
	 * 
	 * @param paginator
	 * @param bean
	 */
	@RequestMapping("email")
	@ResponseBody
	public ResultBean email(Paginator paginator, EmailBean bean) {
		System.out.println(bean);
		try {
			EmailUtil.sendContextEmail(bean.getValue(), "cat监控平台email", bean.getRe(), "cat发送");
		} catch (EmailException e) {
			e.printStackTrace();
			return new ResultBean(false, e.getMessage());
		}
		return new ResultBean(true);
	}

	@RequestMapping(value = { "sms" })
	public ResultBean sms(Paginator paginator, EmailBean bean) {
		System.out.println(bean);
		try {
			EmailUtil.sendContextEmail(bean.getValue(), "cat监控平台sms", "1067165280@qq.com", "cat发送sms");
		} catch (EmailException e) {
			e.printStackTrace();
			return new ResultBean(false, e.getMessage());
		}
		return new ResultBean(true);
	}

	@RequestMapping(value = "weixin")
	public ResultBean weixin(Paginator paginator, EmailBean bean) {
		System.out.println(bean);
		try {
			EmailUtil.sendContextEmail(bean.getValue(), "cat监控平台weixin", "1067165280@qq.com", "cat发送weixin");
		} catch (EmailException e) {
			e.printStackTrace();
			return new ResultBean(false, e.getMessage());
		}
		return new ResultBean(true);

	}
}