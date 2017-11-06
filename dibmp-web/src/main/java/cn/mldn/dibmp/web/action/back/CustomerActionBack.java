package cn.mldn.dibmp.web.action.back;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.service.ICitemService;
import cn.mldn.dibmp.service.ICsourceService;
import cn.mldn.dibmp.service.IProvinceService;
import cn.mldn.dibmp.vo.Citem;
import cn.mldn.dibmp.vo.Csource;
import cn.mldn.dibmp.vo.Customer;
import cn.mldn.dibmp.vo.Province;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/customer/*")
public class CustomerActionBack extends AbstractAction {
	private static final String TITLE = "客户";

	@Resource
	ICsourceService csourceService;
	@Resource
	ICitemService citemService;
	@Resource
	IProvinceService provinceService;
	
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("customer.add.page"));
		List<Csource> findCsource = csourceService.find();
		mav.addObject("csource", findCsource);
		List<Citem> findCitem = citemService.find();
		mav.addObject("citem",findCitem);
		List<Province> findProvince = provinceService.find();
		mav.addObject("province", findProvince);
		return mav;
	}
//	@Resource
//	ICustomerService customerService;

	@RequestMapping("add")
	public ModelAndView add(Customer vo) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "customer.add.action", "vo.add.success", TITLE);
		System.err.println(vo);
		vo.setInDate(new Date());
//		customerService.add(vo);
		return mav;
	}

	@RequestMapping("edit_pre")
	public ModelAndView editPre(long wid) {
		ModelAndView mav = new ModelAndView(super.getPage("customer.edit.page"));
		return mav;
	}

	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "customer.list.action", "vo.edit.success", TITLE);
		return mav;
	}

	@RequestMapping("list")
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("客户姓名:name|联系电话:phone|客户地址:address", "customer.list.action");
		ModelAndView mav = new ModelAndView(super.getPage("customer.list.page"));
		return mav;
	}
}
